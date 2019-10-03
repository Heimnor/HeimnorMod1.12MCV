package com.heimnor.command.staff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.heimnor.utils.NbtCsFile;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class HPerm extends CommandBase
{

	private final List<String> aliases = new ArrayList<String>();

	public HPerm()
	{
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "HPerm";
	}

	@Override
	public List<String> getAliases()
	{
		aliases.add("HPerm");
		aliases.add("hperm");
		return this.aliases;
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return null;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{

		if (!sender.getEntityWorld().isRemote)
		{
			// /hperm add mj <joueur>
			if (args.length == 3)
			{
				NBTTagCompound indexj = NbtCsFile.getData(new File("Heimnor/Permissions.dat")).getCompoundTag("index");
				if (args[0].equals("set"))
				{
					if (indexj.hasKey(args[2]))
					{

						if (args[1].equals("Visiteur") || args[1].equals("Joueur") || args[1].equals("Builder")
								|| args[1].equals("Dev") || args[1].equals("MJ"))
						{

							indexj.setString(args[2], args[1]);
							NbtCsFile.setNbtTagCompound(new File("Heimnor/Permissions.dat"), "index", indexj);
							// log
							System.out.println(args[2] + " est maintenant " + args[1] + " " + indexj);

							Style style = new Style().setColor(TextFormatting.RED);
							ITextComponent component = new TextComponentString(
									args[2] + " est maintenant " + args[1] + ".").setStyle(style);
							sender.sendMessage(component);

						} else
						{
							this.commandExcepetion(sender, 0);
						}

					} else
					{
						this.commandExcepetion(sender, 1);
					}
				}
			} else
			{
				this.commandExcepetion(sender, 2);
			}
		}

	}

	private void commandExcepetion(ICommandSender sender, int errorType)
	{
		Style style = new Style().setColor(TextFormatting.RED);

		if (errorType == 0)
		{
			ITextComponent component = new TextComponentString(
					"[Erreur] Roles possibles : Visiteur, Joueur, MJ, Builder, Dev").setStyle(style);
			sender.sendMessage(component);
		} else if (errorType == 1)
		{
			ITextComponent component = new TextComponentString("[Erreur] Joueur non trouvé.").setStyle(style);
			sender.sendMessage(component);
		} else if (errorType == 2)
		{
			ITextComponent component = new TextComponentString("[Erreur] args invalides : /hperm <set> <role> <joueur>")
					.setStyle(style);
			sender.sendMessage(component);
		}

	}

}
