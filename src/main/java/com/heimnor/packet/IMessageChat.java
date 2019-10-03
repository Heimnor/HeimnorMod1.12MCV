package com.heimnor.packet;

import com.heimnor.common.Heimnor;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IMessageChat implements IMessage {

	public IMessageChat() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {
		

	}

	public static class IMessageHandlerChat implements IMessageHandler<IMessageChat, IMessage> {

		@Override
		public IMessage onMessage(IMessageChat message, MessageContext ctx) {

			EntityPlayerMP player = ctx.getServerHandler().player;
			Heimnor.network.sendToAll(new IMessageChatReponse(player.getDisplayNameString()));
			return null;
		}
	}
}
