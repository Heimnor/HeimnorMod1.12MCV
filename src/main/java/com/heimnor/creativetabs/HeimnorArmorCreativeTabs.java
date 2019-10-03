package com.heimnor.creativetabs;



import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;
import com.heimnor.utils.HeimnorUtils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import registry.ArmorRegistry;


public class HeimnorArmorCreativeTabs extends CreativeTabs {

	public HeimnorArmorCreativeTabs(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ArmorRegistry.ADAMANTE_FEET);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(NonNullList<ItemStack> list)
    {
		super.displayAllRelevantItems(list);
		List<Item> ITEM_SORT = HeimnorUtils.toArrayList(ArmorRegistry.armors);
		Comparator<ItemStack> comparator = Ordering.explicit(ITEM_SORT).onResultOf(ItemStack::getItem);
        list.sort(comparator);
		
    }

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
