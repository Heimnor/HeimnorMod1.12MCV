package com.heimnor.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SyncFood implements IMessage{

	ItemStack stack;
	int slot;
	
	public SyncFood() {}
	
	public SyncFood(ItemStack stack, int slot) {
		this.stack = stack;
		this.slot = slot;
		
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		this.stack = ByteBufUtils.readItemStack(buf);
		this.slot = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		ByteBufUtils.writeItemStack(buf, this.stack);
		ByteBufUtils.writeVarInt(buf, this.slot, 5);
		
	}

	public static class Handler implements IMessageHandler<SyncFood, IMessage>{

		@Override
		public IMessage onMessage(SyncFood message, MessageContext ctx) {
			
			
			Minecraft.getMinecraft().player.inventory.setInventorySlotContents(message.slot, message.stack);
			return null;
		}
		
	}
}
