package com.heimnor.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

public class GuiTextFieldInt extends GuiTextField{

	public GuiTextFieldInt(int id, FontRenderer fontRenderer, int var1, int var2, int var3, int var4) {
		super(id, fontRenderer, var1, var2, var3, var4);
		
	}
	
	public void onlyInt() {
		
		String text = this.getText().replaceAll("\\s", "").replaceAll("\\W", "").replaceAll("\\D", "");
		this.setText(text);
	}
}
