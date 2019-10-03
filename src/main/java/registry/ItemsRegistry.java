package registry;

import com.heimnor.common.Heimnor;

import init.divers.ClochetteMJ;
import init.divers.ItemDes;
import init.divers.ItemHeimnor;
import init.foods.HFood;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(value = Side.CLIENT, modid = Heimnor.MODID)
public class ItemsRegistry
{

	public static final ClochetteMJ CLOCHETTE = new ClochetteMJ();
	public static final ItemDes DES = new ItemDes();
	public static final ItemHeimnor AJ = new ItemHeimnor("aj", Heimnor.HeimnorMiscCreativeTabs);
	public static final ItemHeimnor CASSEROLE = new ItemHeimnor("casserole", Heimnor.HeimnorFoodTabs);
	public static final ItemHeimnor POELE = new ItemHeimnor("poele", Heimnor.HeimnorFoodTabs);
	
	//Food & Container
	public static final ItemHeimnor VERRE_VIN_VIDE = new ItemHeimnor("verre_vin_vide", Heimnor.HeimnorFoodTabs);
	public static final HFood VERRE_VIN_ROUGE = new HFood(1, "verre_vin_rouge", true, VERRE_VIN_VIDE);
	public static final Item CHOPE_VIDE = new ItemHeimnor("chope_vide", Heimnor.HeimnorFoodTabs);
	public static final HFood CHOPE_BIERE = new HFood(1, "chope_biere", true, CHOPE_VIDE);

	public static final Item[] ITEMS = new Item[] { CLOCHETTE, DES, AJ, VERRE_VIN_VIDE, VERRE_VIN_ROUGE, CHOPE_VIDE, CHOPE_BIERE, CASSEROLE, POELE };

	// public static AlcoolHeimnor itemchope = new AlcoolHeimnor(1, "chopebiere");
	// Déclaration des Items Consommables

	public static void setItemName(Item item, String name)
	{
		item.setRegistryName(Heimnor.MODID, name);
		item.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerItemsModels(ModelRegistryEvent event)
	{
		for (int i = 0; i < ITEMS.length; i++)
		{
			registerModel(ITEMS[i], 0);
		}
		// registerModel(itemchope, 0);
	}

	@SideOnly(Side.CLIENT)
	public static void registerModel(Item item, int metadata)
	{
		if (metadata < 0)
			metadata = 0;
		String resourceName = item.getRegistryName().toString();

		if (metadata > 0)
			resourceName += "_m" + String.valueOf(metadata);

		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
	}
}
