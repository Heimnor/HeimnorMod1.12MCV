package com.heimnor.command.staff;

import java.util.ArrayList;
import java.util.List;

import com.heimnor.capabilities.CharacterProvider;
import com.heimnor.utils.HMessageUtils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class HRename extends CommandBase
{

	private final List<String> aliases = new ArrayList<String>();

	@Override
	public String getName()
	{

		return "name";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{

		return "/name <name>";
	}

	@Override
	public List<String> getAliases()
	{
		aliases.add("Name");
		aliases.add("n");
		return this.aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (!sender.getEntityWorld().isRemote)
		{

			EntityPlayer player;

			System.out.println(args);

			if (args.length == 1)
			{
				player = server.getPlayerList().getPlayerByUsername(sender.getName());
				player.getCapability(CharacterProvider.CHAR_CAP, null).setRoleplayName(args[0]);
				HMessageUtils.showInfoHRP("Vous avez été renommé en : " + args[0], player);

			} else if (args.length == 2)
			{

				EntityPlayer origin = server.getPlayerList().getPlayerByUsername(sender.getName());
				EntityPlayer target = server.getPlayerList().getPlayerByUsername(args[1]);

				if (target != null)
				{
					target.getCapability(CharacterProvider.CHAR_CAP, null).setRoleplayName(args[0]);
					HMessageUtils.showInfoHRP("Le joueur " + args[1] + "a été renommé en : " + args[0], origin);
					HMessageUtils.showInfoHRP("Vous avez été renommé en : " + args[0], target);
				} else 
					HMessageUtils.showError("Le joueur : " + args[1] + " n'a pas été trouvé.", origin);

			} else
			{
				player = server.getPlayerList().getPlayerByUsername(sender.getName());
				HMessageUtils.showError("Veuillez utiliser la commande comme ceci : /name <nickname> [username]", player);
			}
		}
	}

}
