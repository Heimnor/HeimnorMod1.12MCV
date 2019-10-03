package com.heimnor.command.player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.heimnor.utils.NbtCsFile;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import registry.ItemsRegistry;

public class CommandAJ extends CommandBase
{

	private final List<String> aliases = new ArrayList<String>();

	public CommandAJ()
	{

	}

	@Override
	public String getName()
	{

		return "aj";
	}

	@Override
	public List<String> getAliases()
	{
		aliases.add("aj");
		aliases.add("AJ");
		aliases.add("Aj");
		aliases.add("aJ");
		return this.aliases;
	}

	@Override
	public String getUsage(ICommandSender sender)
	{

		return "/aj - Distribue vos actions journalières";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{

		World world = sender.getEntityWorld();
		EntityPlayerMP player = CommandAJ.getCommandSenderAsPlayer(sender);
		if (!world.isRemote)
		{

			File joueurs = new File("Heimnor/Joueurs.dat");

			if (joueurs.exists())
			{
				Style chatStyle = new Style().setColor(TextFormatting.DARK_GRAY);

				NBTTagCompound compound = NbtCsFile.getData(joueurs).getCompoundTag("aj");
				if (args.length == 0)
				{
					if (compound.hasKey(sender.getName()))
					{
						long lastWithdraw = compound.getLong(sender.getName());
						long currentTime = System.currentTimeMillis();
						long timeSpend = currentTime - lastWithdraw;
						double timespendDays = (timeSpend / 86400000);
						int nbrAJ = (int) timespendDays * 10;
						if (nbrAJ != 0)
						{
							compound.setLong(sender.getName(), currentTime - (timeSpend % 86400000));
							NbtCsFile.setNbtTagCompound(joueurs, "aj", compound);
							ItemStack stackAJ = new ItemStack(ItemsRegistry.AJ, nbrAJ);
							player.inventory.addItemStackToInventory(stackAJ);

							sender.sendMessage(
									new TextComponentString("Vous avez recu " + nbrAJ + " actions journalières.")
											.setStyle(chatStyle));
						} else
						{
							this.errors(sender, 2);
						}
					} else
					{
						this.errors(sender, 3);
					}
				} else if (args.length == 1 && args[0].equals("set"))
				{

					System.out.println("AJ mis en place");
					compound.setLong(sender.getName(), System.currentTimeMillis());
					NbtCsFile.setNbtTagCompound(joueurs, "aj", compound);
					ITextComponent text = new TextComponentString("Compteur d'AJ mis en place.").setStyle(chatStyle);
					sender.sendMessage(text);

				} else
				{
					this.errors(sender, 1);
				}
			} else
			{
				this.errors(sender, 0);
			}
		}
	}

	private void errors(ICommandSender sender, int error)
	{
		Style errorStyle = new Style().setColor(TextFormatting.RED);
		String errorString = "";
		switch (error)
		{
		case 0:
			errorString = "Erreur interne au serveur (fichier Joueur.dat introuvable).";
			break;
		case 1:
			errorString = "Nombre d'argument invalide : '/aj' ou '/aj set' autorisé uniquement.";
			break;
		case 2:
			errorString = "Veuillez attendre un jour minimum pour retirer vos AJ.";
			break;
		case 3:
			errorString = "Veuillez mettre en place votre compteur d'AJ via la commande \"aj set\"";
			break;
		default:
			errorString = "Erreur inconnue, contactez un administrateur/MJ";
		}
		ITextComponent errorText = new TextComponentString(errorString).setStyle(errorStyle);
		sender.sendMessage(errorText);
	}
}
