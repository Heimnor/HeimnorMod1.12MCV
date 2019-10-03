package init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import registry.BlockRegistry;

public class HeimnorBlock extends Block
{

	public HeimnorBlock(Material material, String name)
	{
		super(material);
		BlockRegistry.setBlockName(this, name);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
	}

}
