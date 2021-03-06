package io.github.mc_umod.block.deco;

import java.util.*;

import io.github.mc_umod.*;
import io.github.mc_umod.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.relauncher.*;

public class BlockOilGlass extends BlockBase {
	
	public BlockOilGlass() {
		super(Material.GLASS);
		this.setSoundType(SoundType.GLASS);
		this.setCreativeTab(UReference.blocks);
	}
	
	public int quantityDropped(Random random) {
		return 0;
	}
	
	protected boolean canSilkHarvest() {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState s) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState s) {
		return true;
	}
	
	@Override
	public boolean isFullBlock(IBlockState s) {
		return true;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
		Block block = iblockstate.getBlock();
		
		if (blockState != iblockstate) {
			return true;
		}
		
		if (block == this) {
			return false;
		}
		
		return block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
