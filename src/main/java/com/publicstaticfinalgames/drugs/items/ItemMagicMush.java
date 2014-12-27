package com.publicstaticfinalgames.drugs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.publicstaticfinalgames.drugs.Main;

public class ItemMagicMush extends ItemFood {

	public ItemMagicMush(int p_i45340_1_, boolean p_i45340_2_) {
		super(p_i45340_1_, p_i45340_2_);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.travelToDimension(Main.highWorldGen.dimensionId);
		
		stack.stackSize--;
		return stack;
	}
}
