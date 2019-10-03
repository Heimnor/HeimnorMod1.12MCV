package com.heimnor.packet;

import com.heimnor.proxy.ClientProxy;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IMessageChatReponse implements IMessage {

	private String username;

	public IMessageChatReponse() {
	}

	public IMessageChatReponse(String text) {
		this.username = text;
	}

	@Override
	public void fromBytes(ByteBuf buf) {

		this.username = 
		ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeUTF8String(buf, username);
	}

	public static class IMessageHandlerChatReponse implements IMessageHandler<IMessageChatReponse, IMessage> {

		@Override
		public IMessage onMessage(IMessageChatReponse message, MessageContext ctx) {

			while (!(ClientProxy.CHATTING_PLAYERS_USERNAME.contains(message.username)))
			{
			ClientProxy.CHATTING_PLAYERS_USERNAME.add(message.username);
			}
			return null;
		}
	}
}
