package com.publicstaticfinalgames.drugs.blocks;

import com.publicstaticfinalgames.drugs.TileEntities.TileEntityCocaineTrace;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CocaineTraceBlock extends BlockContainer {

	public CocaineTraceBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setLightOpacity(0);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityCocaineTrace();
	}
}
