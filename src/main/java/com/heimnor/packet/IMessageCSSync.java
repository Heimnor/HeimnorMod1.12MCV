package com.heimnor.packet;

import java.io.File;
import java.io.IOException;

import com.heimnor.common.Heimnor;
import com.heimnor.utils.NbtCsFile;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class IMessageCSSync implements IMessage {

	NBTTagCompound compound;
	String boolJoueur;
	String identification;
	String modified;

	public IMessageCSSync() {
	}

	public IMessageCSSync(NBTTagCompound compound, String boolJoueur, String identification, String modified) {

		this.compound = compound;
		this.boolJoueur = boolJoueur;
		this.identification = identification;
		this.modified = modified;
	}

	@Override
	public void fromBytes(ByteBuf buf) {

		this.compound = ByteBufUtils.readTag(buf);
		this.boolJoueur = ByteBufUtils.readUTF8String(buf);
		this.identification = ByteBufUtils.readUTF8String(buf);
		this.modified = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {

		ByteBufUtils.writeTag(buf, this.compound);
		ByteBufUtils.writeUTF8String(buf, boolJoueur);
		ByteBufUtils.writeUTF8String(buf, identification);
		ByteBufUtils.writeUTF8String(buf, modified);

	}

	public static class CommonHandler implements IMessageHandler<IMessageCSSync, IMessage> {

		@Override
		public IMessage onMessage(IMessageCSSync message, MessageContext ctx) {

			if (message.boolJoueur.equals("true")) {

				this.syncJoueur(message.identification, message.compound, message.modified);

			} else if (message.boolJoueur.equals("false")) {

				this.syncPerso(message.identification, message.compound, message.modified,
						ctx.getServerHandler().player);
			}

			else if (message.boolJoueur.equals("perm")) {
				this.syncPerm(message.compound, ctx.getServerHandler().player);
			}
			return null;
		}

		private void syncPerm(NBTTagCompound compound, EntityPlayerMP player) {

			NBTTagCompound perm = NbtCsFile.getData(new File("Heimnor/Permissions.dat")).getCompoundTag("index");
			Heimnor.network.sendTo(new IMessageCSSyncRep(perm, "perm"), player);

		}

		private void syncJoueur(String identification, NBTTagCompound compound, String modified) {

			EntityPlayerMP sender = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(identification);
			File joueurs = new File("Heimnor/Joueurs.dat");

			if (!joueurs.exists()) {

				joueurs.getParentFile().mkdirs();
				try {
					joueurs.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			NBTTagCompound compoundServ = NbtCsFile.getData(joueurs).getCompoundTag("index");

			if (compound.equals(compoundServ)) {

				Heimnor.network.sendTo(new IMessageCSSyncRep(compoundServ, "true"), sender);

			}

			if (!compound.equals(compoundServ) && modified.equals("true")) {
				NBTTagCompound playerTag = compound.getCompoundTag(identification);
				NBTTagCompound index = NbtCsFile.getNbtTagCompound(joueurs, "index");
				index.setTag(identification, playerTag);
				NbtCsFile.setNbtTagCompound(joueurs, "index", index);
				Heimnor.network.sendTo(new IMessageCSSyncRep(index, "true"), sender);

			} else if (!compound.equals(compoundServ) && modified.equals("false")) {

				Heimnor.network.sendTo(new IMessageCSSyncRep(compoundServ, "true"), sender);
			}

		}

		private void syncPerso(String identification, NBTTagCompound compound, String modified, EntityPlayerMP player) {

			String playerName = player.getDisplayNameString();
			File fiches = new File("Heimnor/Fiches.dat");
			if (!fiches.exists()) {
				fiches.getParentFile().mkdirs();
				try {
					System.out.println("Fiches.dat crée !");
					fiches.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			NBTTagCompound compoundServ = NbtCsFile.getData(fiches).getCompoundTag("index");
			if (compound.equals(compoundServ)) {

				Heimnor.network.sendTo(new IMessageCSSyncRep(compoundServ, "false"), player);
			}

			if (!compound.equals(compoundServ) && modified.equals("true")) {
				
				NBTTagCompound indexf = NbtCsFile.getNbtTagCompound(fiches, "index");
				NBTTagCompound nbtPerso = compound.getCompoundTag(identification);
				NBTTagCompound nbtPersoServ = indexf.getCompoundTag(identification);
				
				// Logs
				System.out.println(playerName + " a modifie sa fiche perso :");
				System.out.println("Ancienne fiche :" + nbtPersoServ);
				System.out.println("Nouvelle fiche :" + nbtPerso);

				NBTTagList list;
				if (indexf.hasKey("list")) {
					list = indexf.getTagList("list", NBT.TAG_STRING);
				} else {
					list = new NBTTagList();
				}

				if (!list.toString().contains(nbtPerso.getString("nomRP"))) {
					list.appendTag(new NBTTagString(nbtPerso.getString("nomRP")));
				}

				indexf.setTag("list", list);
				indexf.setTag(identification, nbtPerso);
				NbtCsFile.setNbtTagCompound(fiches, "index", indexf);
				Heimnor.network.sendTo(new IMessageCSSyncRep(indexf, "false"), player);

			} else if (!compound.equals(compoundServ) && modified.equals("false")) {
				Heimnor.network.sendTo(new IMessageCSSyncRep(compoundServ, "false"), player);

			} else if (!compound.equals(compoundServ) && modified.equals("delete")) {
				NbtCsFile.setNbtTagCompound(fiches, "index", compound);
				Heimnor.network.sendTo(new IMessageCSSyncRep(compound, "false"), player);

			}

		}
	}
}