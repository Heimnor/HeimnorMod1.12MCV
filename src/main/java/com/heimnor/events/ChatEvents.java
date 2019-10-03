package com.heimnor.events;

import com.heimnor.capabilities.CharacterProvider;
import com.heimnor.utils.FichesUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChatEvents
{

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onChatSending(ClientChatEvent event)
	{

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onChatReceived(ClientChatReceivedEvent event)
	{
	}

	@SubscribeEvent
	public void onChatProcessing(ServerChatEvent event)
	{
		EntityPlayer sender = event.getPlayer();

		if (FichesUtils.hasCharacter(sender))
		{
			String senderName = sender.getCapability(CharacterProvider.CHAR_CAP, null).getRoleplayName();
			int i = senderName.indexOf(" ");
			senderName = senderName.substring(0, i);
			event.setComponent(new TextComponentString(TextFormatting.AQUA + senderName + " : " + TextFormatting.WHITE + event.getMessage()));

		} else {
			event.setCanceled(true);
		}

	}
}
