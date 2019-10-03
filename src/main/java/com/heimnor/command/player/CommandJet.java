package com.heimnor.command.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class CommandJet extends CommandBase
{

	private final List<String> aliases = new ArrayList<String>();

	public CommandJet()
	{

	}

	@Override
	public List<String> getAliases()
	{
		aliases.add("jet");
		aliases.add("j");
		return this.aliases;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_)
	{

		return false;
	}

	@Override
	public String getName()
	{
		return "jet";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "/jet <nombre de dés>d<nombre de faces> <+,-> <bonus/malus>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{

		World world = sender.getEntityWorld();
		int nbrJet = 0;
		int nbrFaces = 0;
		int bonus;
		int malus;
		String username = null;
		String formatResultat;
		int resultatfinal = 0;
		int resultatfinals;

		if (world.isRemote)
		{
		} else
		{
			if (args.length == 0)
			{
				sender.sendMessage(new TextComponentString(
						"Completez la commande comme ceci /jet [nbr]d[nbr] ou /jet [nbr]d[nbr] +/- [nbr]"));
				return;
			}

			if (args.length >= 1)
			{

				if (!(args[0].contains("+")) && !(args[0].contains("-")))
				{

					String[] parts = args[0].split("d");
					Random rand = new Random();
					nbrJet = Integer.parseInt(parts[0]);
					nbrFaces = Integer.parseInt(parts[1]);
					username = sender.getName();

					if (!(nbrJet == 0 || nbrFaces == 0))
					{
						for (int i = 1; i <= nbrJet; i++)
						{

							resultatfinal = resultatfinal + rand.nextInt(nbrFaces) + 1;
						}

						formatResultat = String.format("(%sd%s) %s obtient %s", nbrJet, nbrFaces, username,
								resultatfinal);
						Style Style = new Style().setColor(TextFormatting.GRAY);
						ITextComponent resultat = new TextComponentString(formatResultat).setStyle(Style);
						if (args.length == 2 && (args[1].equals("local") || args[1].equals("l")))
							sender.sendMessage(resultat);
						else
							server.getPlayerList().sendMessage(resultat);

					}

					else
					{
						sender.sendMessage(new TextComponentString("[Erreur] 0 n'est pas un argument valide."));
					}

				} else if (args[0].contains("+"))
				{

					String[] parts = args[0].split("d");

					String[] parts2 = parts[1].split("\\+");

					Random rand = new Random();
					nbrJet = Integer.parseInt(parts[0]);
					System.out.println(parts[1]);
					nbrFaces = Integer.parseInt(parts2[0]);
					bonus = Integer.parseInt(parts2[1]);
					username = sender.getName();
					System.out.println(bonus);
					if (!(nbrJet == 0 || nbrFaces == 0))
					{

						for (int i = 1; i <= nbrJet; i++)
						{

							resultatfinal = resultatfinal + rand.nextInt(nbrFaces) + 1;

						}
						resultatfinals = resultatfinal + bonus;

						formatResultat = String.format("(%sd%s+%s = %s+%s) %s obtient %s", nbrJet, nbrFaces, bonus,
								resultatfinal, bonus, username, resultatfinals);
						Style Style = new Style().setColor(TextFormatting.GRAY);
						ITextComponent resultat = new TextComponentString(formatResultat).setStyle(Style);
						if (args.length == 2 && (args[1].equals("local") || args[1].equals("l")))
							sender.sendMessage(resultat);
						else
							server.getPlayerList().sendMessage(resultat);
					} else
					{
						sender.sendMessage(new TextComponentString("[Erreur] 0 n'est pas un argument valide."));
					}

				} else if (args[0].contains("-"))
				{

					String[] parts = args[0].split("d");

					String[] parts2 = parts[1].split("\\-");

					Random rand = new Random();
					nbrJet = Integer.parseInt(parts[0]);
					System.out.println(parts[1]);
					nbrFaces = Integer.parseInt(parts2[0]);
					malus = Integer.parseInt(parts2[1]);
					username = sender.getName();
					if (!(nbrJet == 0 || nbrFaces == 0))
					{
						for (int i = 1; i <= nbrJet; i++)
						{

							resultatfinal = resultatfinal + rand.nextInt(nbrFaces) + 1;
						}
						resultatfinals = resultatfinal - malus;

						formatResultat = String.format("(%sd%s-%s = %s-%s) %s obtient %s", nbrJet, nbrFaces, malus,
								resultatfinal, malus, username, resultatfinals);
						Style Style = new Style().setColor(TextFormatting.GRAY);
						ITextComponent resultat = new TextComponentString(formatResultat).setStyle(Style);
						System.out.println(" test" + args.length);

						if (args.length == 2 && (args[1].equals("local") || args[1].equals("l")))
						{
							sender.sendMessage(resultat);
						} else
						{
							server.getPlayerList().sendMessage(resultat);
						}

					} else
					{
						sender.sendMessage(new TextComponentString("[Erreur] 0 n'est pas un argument valide."));
					}
				}
			}
		}

	}

}
