package init.divers;

import com.heimnor.common.Heimnor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import registry.ItemsRegistry;
import registry.SoundRegistry;

public class ClochetteMJ extends Item
{

	public static final String NAME = "clochette";

	public ClochetteMJ()
	{

		super();

		this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
		this.setMaxStackSize(1);
		ItemsRegistry.setItemName(this, NAME);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		ItemStack itemclochette = player.getActiveItemStack();

		if (!itemclochette.hasTagCompound())
		{
			itemclochette.setTagCompound(new NBTTagCompound());
			itemclochette.getTagCompound().setInteger("timer", 0);
		}
		if (!world.isRemote && itemclochette.getTagCompound().getInteger("timer") == 0)
		{
			world.playSound(null, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), SoundRegistry.bellSound, SoundCategory.AMBIENT, 1.0F, 1.0F);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));

	}

	public void onUpdate(ItemStack itemclochette, World world, Entity entity, int var1, boolean var2)
	{
		super.onUpdate(itemclochette, world, entity, var1, var2);

		if (entity != null && entity instanceof EntityPlayer)
		{

			if (itemclochette.hasTagCompound())
			{
				NBTTagCompound compound = itemclochette.getTagCompound();

				if (compound.getInteger("timer") > 0)
				{
					compound.setInteger("timer", (compound.getInteger("timer") + 1));
				}
				if (compound.getInteger("timer") >= (10))

					compound.setInteger("timer", 0);
			}
		}
	}
}
