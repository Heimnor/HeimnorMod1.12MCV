package com.heimnor.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import registry.ItemsRegistry;

public class HeimnorCreativeTab extends CreativeTabs
{

	public HeimnorCreativeTab(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ItemsRegistry.CLOCHETTE);
	}

	@Override
	public boolean hasSearchBar()
	{
		return true;
	}

}
