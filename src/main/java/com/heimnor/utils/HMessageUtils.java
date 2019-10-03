package com.heimnor.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class HMessageUtils {

	
	public static void showError(String string, EntityPlayer player) {
		
		TextComponentString text = new TextComponentString(string);
		text.setStyle(new Style().setBold(true).setColor(TextFormatting.RED));
		player.sendMessage(text);
	}
}
