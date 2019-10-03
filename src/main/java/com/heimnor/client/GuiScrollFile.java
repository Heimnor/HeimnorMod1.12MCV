package com.heimnor.client;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.fml.client.GuiScrollingList;

public class GuiScrollFile extends GuiScrollingList
{

	@SuppressWarnings("rawtypes")
	private ArrayList list = new ArrayList();


	public GuiScrollFile(int width, int height, int top, int left, int entryHeight, GuiScreen parent)
	{
		super(Minecraft.getMinecraft(), width, height, top, top + height, left, entryHeight, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		
		

	}

	@Override
	protected int getSize()
	{

		return list.size();
	}

	@Override
	protected void drawBackground()
	{

	}

	@Override
	protected void elementClicked(int index, boolean doubleClick)
	{

	}

	@Override
	protected boolean isSelected(int index)
	{

		return false;
	}

	@Override
	protected void drawSlot(int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess)
	{

	}

}
