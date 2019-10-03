package registry;

import com.heimnor.common.Heimnor;

import init.divers.ItemHeimnor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(value = Side.CLIENT, modid = Heimnor.MODID)
public class MiscRegistry
{

	public static final Item DROGUE1 = new ItemHeimnor("drogue1", Heimnor.HeimnorMiscCreativeTabs);
	public static final Item CLEAN_WATER = new ItemHeimnor("cleanWater", Heimnor.HeimnorMiscCreativeTabs);
	public static final Item DIRTY_WATER = new ItemHeimnor("dirtyWater", Heimnor.HeimnorMiscCreativeTabs);
	public static final Item SALT_WATER = new ItemHeimnor("saltWater", Heimnor.HeimnorMiscCreativeTabs);

	public static Item[] items = new Item[] { CLEAN_WATER, DIRTY_WATER, SALT_WATER, DROGUE1};

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerItemsModels(ModelRegistryEvent event)
	{

		for (int i = 0; i < items.length; i++)
			registerModel(items[i], 0);
	}

	@SideOnly(Side.CLIENT)
	public static void registerModel(Item item, int metadata)
	{

		if (metadata < 0)
			metadata = 0;
		String resourceName = item.getRegistryName().toString().substring(11);

		if (metadata > 0)
			resourceName += "_m" + String.valueOf(metadata);

		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Heimnor.MODID + ":" + resourceName, "inventory"));
	}
}
