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
import registry.ItemsRegistry;

public class HeimnorFoodCreativeTabs extends CreativeTabs{

	public HeimnorFoodCreativeTabs(String lable) {
		super(lable);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemsRegistry.VERRE_VIN_ROUGE);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(NonNullList<ItemStack> list)
    {
		super.displayAllRelevantItems(list);
		List<Item> ITEM_SORT = HeimnorUtils.toArrayList(ItemsRegistry.ITEMS);
		Comparator<ItemStack> comparator = Ordering.explicit(ITEM_SORT).onResultOf(ItemStack::getItem);
        list.sort(comparator);
		
    }
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
