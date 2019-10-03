package com.heimnor.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IMessageLog implements IMessage {

	public String senderName;

	public IMessageLog() {
	}

	public IMessageLog(String message) {
		this.senderName = message;

	}

	@Override
	public void fromBytes(ByteBuf buf) {

		this.senderName = ByteBufUtils.readUTF8String(buf);

	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeUTF8String(buf, this.senderName);

	}

	public static class Handler implements IMessageHandler<IMessageLog, IMessage> {

		@Override
		public IMessage onMessage(IMessageLog message, MessageContext ctx) {

			FMLCommonHandler.instance().getMinecraftServerInstance().logInfo(message.senderName + "a modifié sa fiche de personnage.");

			return null;
		}

	}
}
