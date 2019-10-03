package registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class RegisteringHandler
{

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		
		IForgeRegistry<Block> registry = event.getRegistry();
		
		for (int i = 0; i < BlockRegistry.BLOCKS.length; i++)
		{
			registry.register(BlockRegistry.BLOCKS[i]);
		}
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{

		IForgeRegistry<Item> registry = event.getRegistry();

		//Items
		for (int i = 0; i < ItemsRegistry.ITEMS.length; i++) {
			registry.register(ItemsRegistry.ITEMS[i]);
		}
		
		for (int i = 0; i < MiscRegistry.items.length; i++)
			 registry.register(MiscRegistry.items[i]);


		//Armes
		for (int i = 0; i < WeaponsRegistry.weapons.length; i++)
		{
			registry.register(WeaponsRegistry.weapons[i]);
		}
		
		//Armures
		for (int i = 0; i < ArmorRegistry.armors.length; i++)
		{
			registry.register(ArmorRegistry.armors[i]);
		}
		
		//ItemsBlocks
		for (int i = 0; i < BlockRegistry.ITEMS_BLOCK.length; i++)
		{
			registry.register(BlockRegistry.ITEMS_BLOCK[i]);
		}
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{

		IForgeRegistry<SoundEvent> registry = event.getRegistry();

		registry.registerAll(SoundRegistry.bellSound, SoundRegistry.diceSound,SoundRegistry.equiparmor);
	}
}
