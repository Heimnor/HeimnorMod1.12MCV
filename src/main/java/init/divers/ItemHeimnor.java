package init.divers;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import registry.ItemsRegistry;

public class ItemHeimnor extends Item {


	public ItemHeimnor(String name, CreativeTabs tab) {
		this.setCreativeTab(tab);
		ItemsRegistry.setItemName(this, name);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

		if(stack.getItem() == ItemsRegistry.AJ) {
		tooltip.add(TextFormatting.BLUE + "Vous pourriez avoir une longue journee devant vous.");
		tooltip.add(TextFormatting.BLUE + "Chacune d'elles comptent.");
		tooltip.add(TextFormatting.BLUE + "Utilisez votre temps avec sagesse.");
		}
	}
}
