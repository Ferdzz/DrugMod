package com.publicstaticfinalgames.drugs.TileEntities;

import com.publicstaticfinalgames.drugs.Main;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityDryingRack extends TileEntity {

	// 1 = cocainePaste
	// 2 = cannabisLeave
	public int itemIn = 0;
	public long timer = 0;
	public boolean isDried = false;

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("itemIn", itemIn);
		tag.setLong("timer", timer);
		tag.setBoolean("isDried", isDried);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		itemIn = tag.getInteger("itemIn");
		timer = tag.getLong("timer");
		isDried = tag.getBoolean("isDried");
	}

	public boolean onRightClick(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (player.inventory.getCurrentItem() != null && itemIn == 0 && isDried == false) {
			if (player.inventory.getCurrentItem().getItem().equals(Main.cocainePaste)) {
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Main.cocainePaste, player.inventory.mainInventory[player.inventory.currentItem].stackSize - 1);
				itemIn = 1;
				timer = System.nanoTime();
				return true;
			}
			if (player.inventory.getCurrentItem().getItem().equals(Main.cannabisLeave)) {
				player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack(Main.cannabisLeave, player.inventory.mainInventory[player.inventory.currentItem].stackSize - 1);
				itemIn = 2;
				timer = System.nanoTime();
				return true;
			}
		}
		if (isDried) {
			if (!world.isRemote) {
				if (itemIn == 1) {
					EntityItem item = new EntityItem(world, x, y, z, new ItemStack(Main.cocaine, 1));
					world.spawnEntityInWorld(item);
					itemIn = 0;
					isDried = false;
				}
				if (itemIn == 2) {
					EntityItem item = new EntityItem(world, x, y, z, new ItemStack(Main.cannabisDryied, 1));
					world.spawnEntityInWorld(item);
					itemIn = 0;
					isDried = false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void updateEntity() {
		if (System.nanoTime() >= timer + 200000 && isDried == false && itemIn != 0) {
			isDried = true;
		}
	}
}
