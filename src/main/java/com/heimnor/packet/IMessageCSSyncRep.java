package com.heimnor.packet;

import java.io.File;
import java.io.IOException;

import com.heimnor.utils.NbtCsFile;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IMessageCSSyncRep implements IMessage {

	NBTTagCompound index;
	String boolJoueur;

	public IMessageCSSyncRep() {
	}

	public IMessageCSSyncRep(NBTTagCompound compound, String boolJoueur) {

		this.index = compound;
		this.boolJoueur = boolJoueur;
	}

	@Override
	public void fromBytes(ByteBuf buf) {

		this.index = ByteBufUtils.readTag(buf);
		this.boolJoueur = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeTag(buf, index);
		ByteBufUtils.writeUTF8String(buf, boolJoueur);

	}

	public static class ClientHandler implements IMessageHandler<IMessageCSSyncRep, IMessage> {

		@Override
		public IMessage onMessage(IMessageCSSyncRep message, MessageContext ctx) {

			if (message.boolJoueur.equals("true")) {

				File joueurs = new File("Heimnor/Joueurs.dat");

				if (!joueurs.exists()) {
					try {
						joueurs.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				NbtCsFile.setNbtTagCompound(joueurs, "index", message.index);

			}
			if (message.boolJoueur.equals("false")) {

				File fiches = new File("Heimnor/Fiches.dat");

				if (!fiches.exists()) {
					try {
						fiches.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				NbtCsFile.setNbtTagCompound(fiches, "index", message.index);

			}
			if (message.boolJoueur.equals("perm")) {

				File perm = new File("Heimnor/Permissions.dat");

				if (!perm.exists()) {
					try {
						perm.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				NbtCsFile.setNbtTagCompound(perm, "index", message.index);
			}

			return null;
		}
	}
}