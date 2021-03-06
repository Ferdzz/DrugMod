package com.publicstaticfinalgames.drugs.renderers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.publicstaticfinalgames.drugs.TileEntities.TileEntityDryingRack;
import com.publicstaticfinalgames.drugs.models.ModelDryingRack;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class DryingRackRenderer extends TileEntitySpecialRenderer {

	ModelDryingRack model = new ModelDryingRack();
	
	@Override
	public void renderTileEntityAt(TileEntity dryingRack, double d0, double d1, double d2, float f) {

		bindTexture(new ResourceLocation("swag"));
		
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
           GL11.glTranslatef((float)d0 + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
           GL11.glScalef(1.0F, -1.0F, -1.0F);
                //GL11.glTranslatef(0.5F, 1.0F, 0.5F);
           model.Shape1.render(0.0625F);
           model.Shape2.render(0.0625F);
           model.Shape3.render(0.0625F);
           model.Shape4.render(0.0625F);
           model.Shape5.render(0.0625F);
           model.Shape6.render(0.0625F);
           model.Shape7.render(0.0625F);
           model.Shape8.render(0.0625F);
           model.Shape9.render(0.0625F);
           model.Shape10.render(0.0625F);
           model.Shape11.render(0.0625F);
           model.Shape12.render(0.0625F);
           GL11.glDisable(GL12.GL_RESCALE_NORMAL);
           GL11.glPopMatrix();
           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
           
	}

}
