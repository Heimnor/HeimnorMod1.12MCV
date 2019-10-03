package init.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockHeimnor extends ItemBlock
{

	
	public ItemBlockHeimnor(Block block) {
		super(block);
		
		this.setRegistryName(block.getRegistryName().toString());
	}
}
