package com.publicstaticfinalgames.drugs.dimensions;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class HighWorldGenerator extends WorldProvider {
	
	public HighWorldGenerator() {
		this.dimensionId = 420;
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.beach, this.dimensionId);
	}

	@Override
	public String getDimensionName() {
		return "HighWorld";
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 0;
	}
	
	@Override
	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(50, 5, 0);
	}
	
	@Override
	public String getWelcomeMessage() {
		return "Welcome";
	}
	
	@Override
	public String getDepartMessage() {
		return "Bye";
	}
}
