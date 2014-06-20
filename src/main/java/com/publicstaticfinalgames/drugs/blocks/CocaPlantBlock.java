package com.publicstaticfinalgames.drugs.blocks;

import java.util.Random;

import com.publicstaticfinalgames.drugs.Main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class CocaPlantBlock extends BlockCrops {

	//GetSeedItem
	@Override
	protected Item func_149865_P() {
		return Main.cocaSeed;
	}
	
	@Override
	protected Item func_149866_i() {
		return Main.cocaineLeave;
	}
}
