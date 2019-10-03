package init.foods;

import com.heimnor.common.Heimnor;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import registry.ItemsRegistry;

public class HFood extends ItemFood
{

	public boolean drink;
	public Item container;

	public HFood(int amount, String name, boolean drink)
	{
		super(amount, false);
		this.drink = drink;
		ItemsRegistry.setItemName(this, name);
		this.setCreativeTab(Heimnor.HeimnorFoodTabs);
	}

	public HFood(int amount, String name, boolean drink, Item container)
	{
		super(amount, false);
		this.drink = drink;
		this.container = container;
		ItemsRegistry.setItemName(this, name);
		this.setCreativeTab(Heimnor.HeimnorFoodTabs);
	}

	@Override
	public ItemFood setAlwaysEdible()
	{
		if (this.drink)
			super.setAlwaysEdible();
		return this;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		if (drink)
			return EnumAction.DRINK;

		return EnumAction.EAT;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase player)
	{
		if (player instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer) player;
			entityplayer.getFoodStats().addStats(this, stack);
			worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F,
					worldIn.rand.nextFloat() * 0.1F + 0.9F);
			this.onFoodEaten(stack, worldIn, entityplayer);
			entityplayer.addStat(StatList.getObjectUseStats(this));

			if (entityplayer instanceof EntityPlayerMP)
			{
				CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) entityplayer, stack);
			}

			if (this.container != null)
			{
				ItemStack containerStack = new ItemStack(this.container);
				((EntityPlayer) player).addItemStackToInventory(containerStack);
			}
			stack.shrink(1);
		}
		return stack;
	}
}
