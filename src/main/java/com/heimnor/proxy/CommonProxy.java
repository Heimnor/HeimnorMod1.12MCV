package com.heimnor.proxy;

import java.io.File;
import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;

public class CommonProxy {
	private static final HashMap<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

	public void preInit(File configFile) {

	}

	public void init() {

	}

	public static void storeEntityData(String name, NBTTagCompound compound) {
		((HashMap<String, NBTTagCompound>) extendedEntityData).put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name) {
		return ((HashMap<String, NBTTagCompound>) extendedEntityData).remove(name);
	}

	public void registerRender() {

	}

}
