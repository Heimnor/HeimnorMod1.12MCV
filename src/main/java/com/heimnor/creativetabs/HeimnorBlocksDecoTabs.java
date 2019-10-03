package com.heimnor.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import registry.BlockRegistry;

public class HeimnorBlocksDecoTabs extends CreativeTabs{

	public HeimnorBlocksDecoTabs(String lable) {
		super(lable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(BlockRegistry.MIRROR);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
