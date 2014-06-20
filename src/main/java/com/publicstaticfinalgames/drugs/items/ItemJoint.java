package com.publicstaticfinalgames.drugs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.publicstaticfinalgames.drugs.Main;

public class ItemJoint extends Item {
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if(world.getBlock(x, y + 1, z).equals(Blocks.fire)) {
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 3));
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1200, 0));
			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 900, 1));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 0));
			
			player.inventory.mainInventory[player.inventory.currentItem] = null;
			return true;
		}
		return false;
	}
}
