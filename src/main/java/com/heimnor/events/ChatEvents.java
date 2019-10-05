package com.heimnor.events;

import java.util.ArrayList;
import java.util.List;

import com.heimnor.capabilities.CharacterProvider;
import com.heimnor.proxy.ClientProxy;
import com.heimnor.utils.FichesUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChatEvents
{

	public static boolean checkDistance(BlockPos originPos, BlockPos targetPos, int maxDistance)
	{
		if (originPos.distanceSq(targetPos) <= maxDistance)
			return true;
		else
			return false;
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onGuiDrawing(RenderGameOverlayEvent.Pre event)
	{
		if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR)
		{
			draw(event.getResolution());
		}
	}

	@SubscribeEvent
	public void onChatProcessing(ServerChatEvent event)
	{
		EntityPlayer sender = event.getPlayer();
		event.setCanceled(true);

		List<EntityPlayer> playerHearList = new ArrayList<>();
		String[] playerOnlineNames = FMLCommonHandler.instance().getMinecraftServerInstance().getOnlinePlayerNames();

		if (FichesUtils.hasCharacter(sender) || FichesUtils.isMJ(sender))
		{
			String senderName = sender.getCapability(CharacterProvider.CHAR_CAP, null).getRoleplayName();
			String message = TextFormatting.WHITE + event.getMessage();

			for (int i = 0; i < playerOnlineNames.length; i++)
			{
				EntityPlayer target = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(playerOnlineNames[i]);

				if (checkDistance(sender.getPosition(), target.getPosition(), 100))
				{
					playerHearList.add(target);
				}
			}
			for (int i = 0; i < playerOnlineNames.length; i++)
			{
				EntityPlayer target = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(playerOnlineNames[i]);

				if (playerHearList.contains(target))
					target.sendMessage(new TextComponentString(TextFormatting.AQUA + senderName + " : " + TextFormatting.WHITE + message));
			}

		}

	}

	public static void draw(ScaledResolution res)
	{

		RenderManager renderer = Minecraft.getMinecraft().getRenderManager();
		List<String> typingPlayers = ClientProxy.CHATTING_PLAYERS_USERNAME;
		if (!typingPlayers.isEmpty())
		{

			if (typingPlayers.size() == 1)
			{

				String first = "";

				for (int i = 0; i < typingPlayers.size(); i++)
				{
					first += typingPlayers.get(i) + " ";
				}
				String indic = "est en train d'écrire.";
				renderer.getFontRenderer().drawString(first + indic, 3, res.getScaledHeight() - 35, 0xFFFFFF);
			} else
			{
				String first = "";

				for (int i = 0; i < typingPlayers.size(); i++)
				{
					if (i != typingPlayers.size()-1)
						first += typingPlayers.get(i) + ", ";
					else
						first += typingPlayers.get(i) + " ";
				}
				String indic = "sont en train d'écrire.";
				renderer.getFontRenderer().drawString(first + indic, 3, res.getScaledHeight() - 35, 0xFFFFFF);
			}

		}

	}
}
