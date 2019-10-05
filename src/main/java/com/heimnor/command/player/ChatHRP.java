package com.heimnor.command.player;

import java.util.ArrayList;
import java.util.List;

import com.heimnor.capabilities.CharacterProvider;
import com.heimnor.utils.FichesUtils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ChatHRP extends CommandBase
{

	private final List<String> aliases = new ArrayList<String>();

	@Override
	public String getName()
	{

		return "hrp";
	}

	@Override
	public List<String> getAliases()
	{
		this.aliases.add("h");
		return this.aliases;
	}

	@Override
	public String getUsage(ICommandSender sender)
	{

		return "/hrp <message>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		EntityPlayer senderPlayer = server.getPlayerList().getPlayerByUsername(sender.getName());
		String[] playerOnlineNames = FMLCommonHandler.instance().getMinecraftServerInstance().getOnlinePlayerNames();

		if (FichesUtils.hasCharacter(senderPlayer) || FichesUtils.isMJ(senderPlayer))
		{
			String senderName = senderPlayer.getCapability(CharacterProvider.CHAR_CAP, null).getRoleplayName();
			String message = "";
			
			for(int i = 0; i< args.length; i++)
				message += " " + args[i];

			for (int i = 0; i < playerOnlineNames.length; i++)
			{
				EntityPlayer target = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(playerOnlineNames[i]);
				target.sendMessage(new TextComponentString(TextFormatting.GRAY + "[HRP]" + senderName + " :" + message));
			}

		}

	}

}
