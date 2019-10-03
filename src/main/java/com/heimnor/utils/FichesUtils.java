package com.heimnor.utils;

import java.io.File;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class FichesUtils
{

	private static File joueursFile = new File("Heimnor/Joueurs.dat");
	private static File permissions = new File("Heimnor/Permissions.dat");

	public FichesUtils(EntityPlayer player)
	{
	}

	public static boolean isMJ(EntityPlayer player)
	{

		NBTTagCompound indexPerm = NbtCsFile.getData(permissions).getCompoundTag("index");
		if (permissions.exists())
		{
			if (indexPerm.hasKey(player.getDisplayNameString()))
			{
				String status = indexPerm.getString(player.getDisplayNameString());
				if (status.equals("MJ"))
				{
					return true;
				} else
				{
					return false;
				}
			}
		}
		return false;
	}

	public static int getCuisine(EntityPlayer player)
	{

		if (hasCharacter(player))
		{

			String persoName = NbtCsFile.getData(new File("Heimnor/Joueurs.dat")).getCompoundTag("index").getCompoundTag(player.getDisplayNameString()).getString("perso");
			int cuisine = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index").getCompoundTag(persoName).getInteger("cuisine");
			return cuisine;
		} else
		{
			return 0;
		}

	}

	public static boolean hasCharacter(EntityPlayer player)
	{
		boolean hasCharacter = NbtCsFile.getData(joueursFile).getCompoundTag("index").getCompoundTag(player.getDisplayNameString()).hasKey("perso");
		return hasCharacter;
	}

	public static String getRPName(EntityPlayer player)
	{
		if (hasCharacter(player))
		{
			String nameRP = NbtCsFile.getData(joueursFile).getCompoundTag("index").getCompoundTag(player.getDisplayNameString()).getString("perso");

			return nameRP;

		} else
			return null;
	}

	public static int throwOneComp(EntityPlayer player, String comp1Name, int comp1, World world)
	{

		Random rand = new Random();
		int jet = rand.nextInt(20) + 1;
		int resultat = jet + comp1;

		String formula = "(" + jet + "+" + comp1 + "=" + resultat + ")";

		ITextComponent chatMsg = new TextComponentString(
				TextFormatting.DARK_GRAY + "[" + comp1Name + "]" + formula + TextFormatting.GRAY + player.getDisplayNameString() + " obtient " + resultat + ".");
		player.sendMessage(chatMsg);

		return resultat;
	}

	public static int throwTwoComp(EntityPlayer player, String comp1Name, int comp1, String comp2Name, int comp2)
	{

		Random rand = new Random();
		int jet = rand.nextInt(20);
		int resultat = jet + comp1 + comp2;

		String formula = "(" + jet + "+" + comp1 + "+" + comp2 + "=" + resultat + ")";
		ITextComponent chatMsg = new TextComponentString(
				TextFormatting.DARK_GRAY + "[" + comp1Name + " + " + comp2Name + "]" + formula + TextFormatting.GRAY + player.getDisplayNameString() + "obtient" + resultat + ".");
		player.sendMessage(chatMsg);
		return resultat;
	}

	public static int ThrowPhys(EntityPlayer player)
	{

		if (hasCharacter(player))
		{
			String persoName = NbtCsFile.getData(new File("Heimnor/Joueurs.dat")).getCompoundTag("index").getCompoundTag(player.getDisplayNameString()).getString("perso");
			int fo = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index").getCompoundTag(persoName).getInteger("force");
			int ag = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index").getCompoundTag(persoName).getInteger("agilite");
			int comp;
			String compName;
			if (ag < fo)
			{
				comp = fo;
				compName = "FO";
			} else if (ag > fo)
			{
				comp = ag;
				compName = "AG";
			} else
			{
				comp = fo;
				compName = "FO/AG";
			}

			Random rand = new Random();
			int jet = 1 + rand.nextInt(20);
			int results = jet + comp;

			String formula = "(" + jet + "+" + comp + "=" + results + ")";
			TextComponentString text = new TextComponentString(
					TextFormatting.DARK_GRAY + "[" + compName + "]" + formula + TextFormatting.GRAY + player.getDisplayNameString() + " obtient " + results + ".");
			player.sendMessage(text);
			return results;
		}
		return -1;
	}
}
