package init.blocks;

import com.heimnor.common.Heimnor;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class HDecoBlock extends BlockHDir
{

	public HDecoBlock(Material material, String name)
	{
		super(material, name);
		this.setCreativeTab(Heimnor.HeimnorBlockDecoTabs);
	
	}
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }

}
