package com.publicstaticfinalgames.drugs;


import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.publicstaticfinalgames.drugs.TileEntities.TileEntityCocaineTrace;
import com.publicstaticfinalgames.drugs.TileEntities.TileEntityDryingRack;
import com.publicstaticfinalgames.drugs.TileEntities.TileEntityGrinder;
import com.publicstaticfinalgames.drugs.renderers.CocaineTraceRenderer;
import com.publicstaticfinalgames.drugs.renderers.DryingRackRenderer;
import com.publicstaticfinalgames.drugs.renderers.GrinderRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	CocaineTraceRenderer cocaineTrace = new CocaineTraceRenderer();
	DryingRackRenderer dryingRack = new DryingRackRenderer();
	GrinderRenderer grinder = new GrinderRenderer();
	
	@Override
    public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCocaineTrace.class, cocaineTrace);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDryingRack.class, dryingRack);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinder.class, grinder);
		
		
		//TODO Add grinder hand renderer
//		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.cocaineTrace), cocaineTrace);
//		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.grinder), grinder);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.dryingRack), dryingRack);
		
//		ClientRegistry.registerTileEntity(TileEntityCocaineTrace.class, "cocainetrace", new CocaineTraceRenderer());
//		ClientRegistry.registerTileEntity(TileEntityDryingRack.class, "dryingrack", new DryingRackRenderer());
//		ClientRegistry.registerTileEntity(TileEntityGrinder.class, "grinder", new GrinderRenderer());
	}
}