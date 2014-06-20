package com.publicstaticfinalgames.drugs.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.publicstaticfinalgames.drugs.Main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CannabisPlantBlock extends BlockCrops {

	@Override
	public Item getItemDropped(int stage, Random rand, int p_149650_3_) {

		if (stage > 5) {
			return Main.cannabisLeave;
		} else {
			return Main.cannabisSeed;
		}
	}
}
