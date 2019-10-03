package init.armor;

import com.heimnor.common.Heimnor;
import com.heimnor.henum.EnumArmorHeimnor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import registry.ArmorRegistry.ArmorCategories;
import registry.ItemsRegistry;


public class HArmor extends ItemArmor {

	private float varMotionX = 1.0F;
	private float varMotionZ = 1.0F;

	private EnumArmorHeimnor armor;
	private float moveMin;
	private float moveMax;
	private EntityEquipmentSlot type;

	public HArmor(ArmorMaterial material, EnumArmorHeimnor texture, EntityEquipmentSlot type, ArmorCategories move, String name) {
		super(material, 0, type);
		this.armor = texture;
		this.moveMin = move.getMoveMin();
		this.moveMax = move.getMoveMax();
		this.type = type;
		this.setCreativeTab(Heimnor.HeimnorArmorCreativeTabs);
		ItemsRegistry.setItemName(this, name);

	}
	
	//Ne plus utiliser
	@Deprecated
	public HArmor(String oldRegistryName,ArmorMaterial material, EnumArmorHeimnor textures, EntityEquipmentSlot type, ArmorCategories move, String name) {
		super(material, 0, type);
		this.armor = textures;
		this.moveMin = move.getMoveMin();
		this.moveMax = move.getMoveMax();
		this.type = type;
		this.setCreativeTab(Heimnor.HeimnorArmorCreativeTabs);
		this.setUnlocalizedName(name);
		this.setRegistryName(Heimnor.MODID, oldRegistryName);

	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (this.type == EntityEquipmentSlot.LEGS && !this.armor.getLayer2().equals("")) {
			return this.armor.getLayer2();
		}
		if (!this.armor.getLayer1().equals(""))
			return this.armor.getLayer1();
		return null;
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (this.armorType == EntityEquipmentSlot.HEAD && player.onGround) {
			player.motionX *= varMotionX - this.moveMin;
			player.motionZ *= varMotionZ - this.moveMin;
		}
		if (this.armorType == EntityEquipmentSlot.CHEST && player.onGround) {
			player.motionX *= varMotionX - this.moveMax;
			player.motionZ *= varMotionZ - this.moveMax;

		}
		if (this.armorType == EntityEquipmentSlot.LEGS && player.onGround) {
			player.motionX *= varMotionX - this.moveMax;
			player.motionZ *= varMotionZ - this.moveMax;

		}
		if (this.armorType == EntityEquipmentSlot.FEET && player.onGround) {
			player.motionX *= varMotionX - this.moveMin;
			player.motionZ *= varMotionZ - this.moveMin;
		}
	}
}
