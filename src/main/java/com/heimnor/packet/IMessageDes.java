package com.heimnor.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IMessageDes implements IMessage {

	private String playerJet;
	private int resultatDes;

	public IMessageDes() {

	}

	public IMessageDes(String text, int resultatfinal) {
		this.playerJet = text;
		this.resultatDes = resultatfinal;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.playerJet = ByteBufUtils.readUTF8String(buf);
		this.resultatDes = ByteBufUtils.readVarInt(buf, 1);
	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeUTF8String(buf, playerJet);
		ByteBufUtils.writeVarInt(buf, resultatDes, 1);

	}

	public static class IMesageDesHandler implements IMessageHandler<IMessageDes, IMessage> {

		@Override
		public IMessage onMessage(IMessageDes message, MessageContext ctx) {

			String stringresultat = String.format("[Dés]" + message.playerJet + " à jeté les dés et obtient un score de " + message.resultatDes + ".",
					message.playerJet, message.resultatDes);
			Style chatstyle = new Style().setColor(TextFormatting.GRAY);
			ITextComponent resultat = new TextComponentString(stringresultat).setStyle(chatstyle);
			FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().sendMessage(resultat);

			return null;
		}

	}
}