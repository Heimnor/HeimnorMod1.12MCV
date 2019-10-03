package com.heimnor.capabilities;

import com.heimnor.common.Heimnor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler
{
	public static final ResourceLocation CHAR_CAP = new ResourceLocation(Heimnor.MODID, "character");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		
		if(event.getObject() instanceof EntityPlayer)
			event.addCapability(CHAR_CAP, new CharacterProvider());
	}
}
