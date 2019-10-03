package init.divers;

import java.util.List;
import java.util.Random;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageDes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import registry.ItemsRegistry;
import registry.SoundRegistry;

public class ItemDes extends Item
{

	public ItemDes()
	{

		super();
		this.setCreativeTab(Heimnor.HeimnorMiscCreativeTabs);
		ItemsRegistry.setItemName(this, "des");
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		ItemStack itemdes = player.getActiveItemStack();

		NBTTagCompound compound;

		if (!itemdes.hasTagCompound())
		{

			compound = new NBTTagCompound();
			compound.setInteger("timer", 0);
			itemdes.setTagCompound(compound);
		}
		if (itemdes.getTagCompound().getInteger("timer") == 0)
		{
			if (world.isRemote)
			{
				compound = itemdes.getTagCompound();
				Random rand = new Random();
				int resultatDes1 = rand.nextInt(6) + 1;
				int resultatDes2 = rand.nextInt(6) + 1;
				int resultatfinal = resultatDes1 + resultatDes2;
				String playerJet = Minecraft.getMinecraft().player.getDisplayNameString();

				Heimnor.network.sendToServer(new IMessageDes(playerJet, resultatfinal));
				compound.setInteger("timer", 1);
				itemdes.setTagCompound(compound);
			} else if (!world.isRemote)
				world.playSound(null, player.getPosition().getX(), player.getPosition().getY(),
						player.getPosition().getZ(), SoundRegistry.diceSound, SoundCategory.AMBIENT, 0.2F, 1.0F);

		}

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	public void onUpdate(ItemStack itemdes, World world, net.minecraft.entity.Entity entity, int var1, boolean var2)
	{
		super.onUpdate(itemdes, world, entity, var1, var2);

		if (entity != null && entity instanceof EntityPlayer)
		{

			if (itemdes.hasTagCompound())
			{
				NBTTagCompound compound = itemdes.getTagCompound();
				if (compound.getInteger("timer") > 0)
				{
					compound.setInteger("timer", (compound.getInteger("timer") + 1));
				}
				if (compound.getInteger("timer") >= (20))

					compound.setInteger("timer", 0);
				itemdes.setTagCompound(compound);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		tooltip.add(TextFormatting.GRAY + "2 dés à 6 faces.");
		tooltip.add(TextFormatting.GRAY + "La base de nombreux jeux depuis des siècles.");
	}
}