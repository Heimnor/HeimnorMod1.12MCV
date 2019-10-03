package com.heimnor.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import registry.ItemsRegistry;

public class HeimnorMiscCreativeTab extends CreativeTabs {

	public HeimnorMiscCreativeTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemsRegistry.DES);
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
