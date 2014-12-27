package com.publicstaticfinalgames.drugs;


import com.publicstaticfinalgames.drugs.TileEntities.TileEntityCocaineTrace;
import com.publicstaticfinalgames.drugs.TileEntities.TileEntityDryingRack;
import com.publicstaticfinalgames.drugs.TileEntities.TileEntityGrinder;
import com.publicstaticfinalgames.drugs.renderers.CocaineTraceRenderer;
import com.publicstaticfinalgames.drugs.renderers.DryingRackRenderer;
import com.publicstaticfinalgames.drugs.renderers.GrinderRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
    public void registerRenderers() {
		ClientRegistry.registerTileEntity(TileEntityCocaineTrace.class, "cocainetrace", new CocaineTraceRenderer());
		ClientRegistry.registerTileEntity(TileEntityDryingRack.class, "dryingrack", new DryingRackRenderer());
		ClientRegistry.registerTileEntity(TileEntityGrinder.class, "grinder", new GrinderRenderer());
	}
}