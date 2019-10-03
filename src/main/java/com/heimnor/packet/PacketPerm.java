package com.heimnor.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketPerm implements IMessage{

	public PacketPerm() {}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	public static class Handler implements IMessageHandler<PacketPerm, IMessage>{

		@Override
		public IMessage onMessage(PacketPerm message, MessageContext ctx) {
			
			System.out.println("Packet reçu");
			
			return null;
		}
		
	}
}
