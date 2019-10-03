package registry;

import com.heimnor.common.Heimnor;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundRegistry
{
	public static SoundEvent bellSound = registerSound("clochette_sound"); 
	public static SoundEvent diceSound = registerSound("des_sound");
	public static SoundEvent equiparmor = registerSound("equiparmor");

	
	public static SoundEvent registerSound(String name) {
		
		ResourceLocation location = new ResourceLocation(Heimnor.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(Heimnor.MODID, name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		
		return event;
	}

}
