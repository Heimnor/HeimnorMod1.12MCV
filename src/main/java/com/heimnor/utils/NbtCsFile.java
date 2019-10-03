package com.heimnor.utils;

import java.io.File;
import java.io.IOException;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;

public class NbtCsFile {

	public static NBTTagCompound getData(File file) {

		if(file.exists()) {
		try {
			return CompressedStreamTools.read(file);

		} catch (IOException e) {

			e.printStackTrace();
		}
		return new NBTTagCompound();
		}else {
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				return CompressedStreamTools.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new NBTTagCompound();
		}
	}

	public static NBTTagList getNBTTagList(File file, String tag) {
		
		NBTTagCompound nbtCompound = null;
		
		try {
			nbtCompound = CompressedStreamTools.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		NBTTagList nbtCompound2 = nbtCompound.getTagList(tag, NBT.TAG_LIST);
		
		return nbtCompound2;
	}
	
	public static void setNBTTagList(File file, NBTTagList nbtTagList, String tag) {
		
	}
	
	public static NBTTagCompound getNbtTagCompound(File file, String tag) {
		NBTTagCompound tagCompound = new NBTTagCompound();
		
		try {
			tagCompound = CompressedStreamTools.read(file);

		} catch (IOException e) {

			e.printStackTrace();
		}
		NBTTagCompound tagsend = tagCompound.getCompoundTag(tag);
		if(tagsend != null)
		return tagsend;
		else
			return null;
	}

	public static void setNbtTagCompound(File file, String tag, NBTTagCompound tagCompound) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(file);
			data.setTag(tag, tagCompound);
			CompressedStreamTools.write(data, file);
		} catch (Exception e) {
			try {
				data = new NBTTagCompound();
				data.setTag(tag, tagCompound);
				CompressedStreamTools.write(data, file);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	public static boolean getBoolean(File file, String tag) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(file);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return data.getBoolean(tag);
	}

	public static void setBoolean(File file, String tag, Boolean bool) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(file);
			data.setBoolean(tag, bool);
			CompressedStreamTools.write(data, file);
		} catch (Exception e) {
			try {
				data = new NBTTagCompound();
				data.setBoolean(tag, bool);
				CompressedStreamTools.write(data, file);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public static String getString(File file, String tag) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(file);

		} catch (Exception e) {
			{
				return "";
			}
		}
		return data.getString(tag);
	}

	public static void setString(File file, String tag, String string) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(file);
			data.setString(tag, string);
			CompressedStreamTools.write(data, file);
		} catch (Exception e) {
			try {
				data = new NBTTagCompound();
				data.setString(tag, string);
				CompressedStreamTools.write(data, file);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public static int getInteger(File dataFile, String tag) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(dataFile);
		} catch (Exception e) {

			return 0;

		}
		return data.getInteger(tag);
	}

	public static void setInteger(File dataFile, String tag, int i) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(dataFile);
			data.setInteger(tag, i);
			CompressedStreamTools.write(data, dataFile);
		} catch (Exception e) {
			try {
				data = new NBTTagCompound();
				data.setInteger(tag, i);
				CompressedStreamTools.write(data, dataFile);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public static boolean hasKey(File dataFile, String tag) {
		NBTTagCompound data;
		try {
			data = CompressedStreamTools.read(dataFile);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
			
		}
		return data.hasKey(tag);
	}
	
}
