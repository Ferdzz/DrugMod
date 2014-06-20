package com.publicstaticfinalgames.drugs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.publicstaticfinalgames.drugs.Main;

public class ItemCocaine extends Item {

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2) {
		if (side == 1 && world.getBlock(x, y + 1, z).equals(Blocks.air)) {
			world.setBlock(x, y + 1, z, Main.cocaineTrace);
			
			player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Main.cocaine, player.inventory.mainInventory[player.inventory.currentItem].stackSize - 1);
			return true;
		}
		return false;
	}

}
