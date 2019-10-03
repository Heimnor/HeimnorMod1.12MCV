package com.heimnor.events;

import java.io.File;

import com.heimnor.utils.NbtCsFile;

import net.minecraft.nbt.NBTTagCompound;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ServerEvents {

	
	@SubscribeEvent
	public void onPlayerConnection(PlayerEvent.PlayerLoggedInEvent event) {
	
		File permissions = new File("Heimnor/Permissions.dat");
		if(permissions.exists()) {
			if(!NbtCsFile.getData(permissions).getCompoundTag("index").hasKey(event.player.getDisplayNameString())) {
				
				NBTTagCompound index = NbtCsFile.getNbtTagCompound(permissions, "index");
				index.setString(event.player.getDisplayNameString(), "Visiteur");
				NbtCsFile.setNbtTagCompound(permissions, "index", index);
			}
		}
	}
}
