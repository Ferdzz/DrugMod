package com.publicstaticfinalgames.drugs.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCookedBrownie extends ItemFood {

	public ItemCookedBrownie(int p_i45339_1_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_3_);
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 3));
		player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1200, 0));
		player.addPotionEffect(new PotionEffect(Potion.hunger.id, 900, 1));
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 0));
				
		return super.onEaten(par1ItemStack, par2World, player);
	}
}
