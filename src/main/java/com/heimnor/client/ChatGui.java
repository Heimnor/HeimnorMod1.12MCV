package com.heimnor.client;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageChat;
import com.heimnor.packet.IMessageChatClose;

import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ChatGui extends GuiChat {

	@Override
	public void initGui()
    {
		super.initGui();
		Heimnor.network.sendToServer(new IMessageChat());
    }
	
	
	@Override
	public void onGuiClosed() {
		
		super.onGuiClosed();
		Heimnor.network.sendToServer(new IMessageChatClose());
	}
}
