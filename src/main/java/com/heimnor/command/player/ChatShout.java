package com.heimnor.command.player;

import java.util.ArrayList;
import java.util.List;

import com.heimnor.capabilities.CharacterProvider;
import com.heimnor.events.ChatEvents;
import com.heimnor.utils.FichesUtils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ChatShout extends CommandBase
{

	private final List<String> aliases = new ArrayList<String>();

	@Override
	public String getName()
	{

		return "crier";
	}

	@Override
	public List<String> getAliases()
	{
		this.aliases.add("c");
		return this.aliases;
	}

	@Override
	public String getUsage(ICommandSender sender)
	{

		return "/crier <message>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		EntityPlayer senderPlayer = server.getPlayerList().getPlayerByUsername(sender.getName());

		List<EntityPlayer> playerHearList = new ArrayList<>();
		String[] playerOnlineNames = FMLCommonHandler.instance().getMinecraftServerInstance().getOnlinePlayerNames();

		if (FichesUtils.hasCharacter(senderPlayer) || FichesUtils.isMJ(senderPlayer))
		{
			String senderName = senderPlayer.getCapability(CharacterProvider.CHAR_CAP, null).getRoleplayName();
			String message = "";
			
			for (int i = 0; i < args.length; i++)
				message += " " + args[i];

			for (int i = 0; i < playerOnlineNames.length; i++)
			{
				EntityPlayer target = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(playerOnlineNames[i]);

				if (ChatEvents.checkDistance(sender.getPosition(), target.getPosition(), 625))
				{
					playerHearList.add(target);
				}
			}
			for (int i = 0; i < playerOnlineNames.length; i++)
			{
				EntityPlayer target = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(playerOnlineNames[i]);

				if (playerHearList.contains(target))
					target.sendMessage(new TextComponentString(TextFormatting.AQUA + senderName + " : " + TextFormatting.RED + message));
			}

		}

	}

}
