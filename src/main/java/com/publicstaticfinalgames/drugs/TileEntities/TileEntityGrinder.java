package com.publicstaticfinalgames.drugs.TileEntities;

import java.util.Random;

import com.publicstaticfinalgames.drugs.Main;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityGrinder extends TileEntity {

	public int counter = 0;
	public boolean hasWeed = false;

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("hasWeed", hasWeed);
		tag.setInteger("counter", counter);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		hasWeed = tag.getBoolean("hasWeed");
		counter = tag.getInteger("counter");
	}

	public boolean update(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (player.inventory.getCurrentItem() != null) {
			if (player.inventory.getCurrentItem().getItem().equals(Main.cannabisDryied) && hasWeed == false) {
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Main.cannabisDryied, player.inventory.mainInventory[player.inventory.currentItem].stackSize - 1);
				hasWeed = true;
				return true;
			}
		}
		if (hasWeed == true && counter < 7) {
			if (!world.isRemote)
				counter++;
			return true;
		}
		if (counter == 7) {
			EntityItem item = new EntityItem(world, x, y, z, new ItemStack(Main.cannabisSeed, 2));
			if (!world.isRemote) {
				world.spawnEntityInWorld(item);
				item = new EntityItem(world, x, y, z, new ItemStack(Main.cannabisGrinded, 2));
				world.spawnEntityInWorld(item);
				counter = 0;
				hasWeed = false;
			}
			return true;
		}

		return false;
	}
}
