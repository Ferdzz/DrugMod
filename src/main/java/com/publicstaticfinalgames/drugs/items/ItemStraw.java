package com.publicstaticfinalgames.drugs.items;

import com.publicstaticfinalgames.drugs.blocks.CocaineTraceBlock;

import cpw.mods.fml.common.Mod.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemStraw extends Item {

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (world.getBlock(x, y, z) instanceof CocaineTraceBlock) {
			world.setBlockToAir(x, y, z);
			stack.damageItem(2, player);
			if (stack.getItemDamage() >= stack.getMaxDamage()) {
				stack.damageItem(1, player);
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 2));
				player.attackEntityFrom(new DamageSource("strawkill"), 4);
			}
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1000, 5));

			return true;
		}
		return false;
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		
	}
}