package init.weapons;

import com.heimnor.common.Heimnor;

import net.minecraft.item.ItemSword;
import registry.ItemsRegistry;

public class Armes extends ItemSword
{

	public Armes(ToolMaterial material, String name) {
		super(material);
		
		this.setCreativeTab(Heimnor.HeimnorWeaponCreativeTabs);
		ItemsRegistry.setItemName(this, name);
	}
}
