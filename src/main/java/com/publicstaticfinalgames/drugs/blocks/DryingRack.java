package com.publicstaticfinalgames.drugs.blocks;

import com.publicstaticfinalgames.drugs.TileEntities.TileEntityDryingRack;
import com.publicstaticfinalgames.drugs.TileEntities.TileEntityGrinder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DryingRack extends BlockContainer {

	public DryingRack(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityDryingRack();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		return ((TileEntityDryingRack) world.getTileEntity(x, y, z)).onRightClick(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
	}

}
