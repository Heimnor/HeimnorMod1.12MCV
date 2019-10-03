package com.heimnor.common;

import com.heimnor.client.FichesGui;
import com.heimnor.client.GuiListCS;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CSGuiHandler implements IGuiHandler {

	public static final int CHARACTER_SHEET_GUI = 0;
	public static final int CHARACTER_SHEET_LIST = 2;

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == CHARACTER_SHEET_GUI)
			return new FichesGui();

		if (ID == CHARACTER_SHEET_LIST)
			return new GuiListCS();

		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		return null;
	}

}
