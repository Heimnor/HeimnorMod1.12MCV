package init.drinks;

import com.heimnor.common.Heimnor;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import registry.ItemsRegistry;

public class AlcoolHeimnor extends ItemFood
{

	public AlcoolHeimnor(int amount, String name)
	{
		super(amount, false);
		this.setCreativeTab(Heimnor.HeimnorFoodTabs);
		ItemsRegistry.setItemName(this, name);
	}

	@Override
	public ItemFood setAlwaysEdible()
	{
		return super.setAlwaysEdible();
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.DRINK;
	}
}
