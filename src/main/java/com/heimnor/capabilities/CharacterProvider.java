package com.heimnor.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CharacterProvider implements ICapabilitySerializable<NBTBase>
{

	@CapabilityInject(ICharacterRP.class)
	public static final Capability<ICharacterRP> CHAR_CAP = null;
	
	private ICharacterRP instance = CHAR_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == CHAR_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == CHAR_CAP ? CHAR_CAP.cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
		
		return CHAR_CAP.getStorage().writeNBT(CHAR_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		CHAR_CAP.getStorage().readNBT(CHAR_CAP, this.instance, null, nbt);
	}

}
