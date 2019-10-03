package registry;

import com.heimnor.common.Heimnor;

import init.blocks.HDecoBlock;
import init.blocks.HeimnorBlock;
import init.blocks.ItemBlockHeimnor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(value = Side.CLIENT, modid = Heimnor.MODID)
public class BlockRegistry
{
	
	public static final Block PLAN_DE_TRAVAIL = new HeimnorBlock(Material.ROCK, "plan_de_travail").setCreativeTab(Heimnor.HeimnorBlockTabs);
	public static final ItemBlockHeimnor ITEM_PLAN_DE_TRAVAIL = new ItemBlockHeimnor(PLAN_DE_TRAVAIL);
	
	public static final Block MIRROR = new HDecoBlock(Material.ROCK, "mirror");
	public static final ItemBlockHeimnor ITEM_MIRROR = (ItemBlockHeimnor) new ItemBlockHeimnor(MIRROR);
	
	public static final Block[] BLOCKS = new Block[] {PLAN_DE_TRAVAIL, MIRROR};
	public static final Item[] ITEMS_BLOCK = new Item[] {ITEM_PLAN_DE_TRAVAIL, ITEM_MIRROR};
	
	public static void setBlockName(Block block, String name) {
		
		block.setUnlocalizedName(name);
		block.setRegistryName(Heimnor.MODID, name);
		
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerItemsModels(ModelRegistryEvent event)
	{

		for (int i = 0; i < ITEMS_BLOCK.length; i++)
			registerModel(ITEMS_BLOCK[i]);
	}
	
	@SideOnly(Side.CLIENT)
	private static void registerModel(Item item) {
		
		String resourceName = item.getRegistryName().toString().substring(11);
		
		ModelLoader.setCustomModelResourceLocation(	item , 0, new ModelResourceLocation(Heimnor.MODID + ":itemblock/" + resourceName, "inventory"));
	}
}
