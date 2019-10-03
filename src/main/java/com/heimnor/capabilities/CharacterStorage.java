package com.heimnor.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CharacterStorage implements IStorage<ICharacterRP>
{

	@Override
	public NBTBase writeNBT(Capability<ICharacterRP> capability, ICharacterRP instance, EnumFacing side)
	{
		
		return new NBTTagString(instance.getRoleplayName());
	}

	@Override
	public void readNBT(Capability<ICharacterRP> capability, ICharacterRP instance, EnumFacing side, NBTBase nbt)
	{
		
		instance.setRoleplayName(((NBTTagString)nbt).getString());
	}

}
