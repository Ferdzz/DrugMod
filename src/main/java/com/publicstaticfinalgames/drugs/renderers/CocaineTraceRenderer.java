package com.publicstaticfinalgames.drugs.renderers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.publicstaticfinalgames.drugs.models.ModelCocaineTrace;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class CocaineTraceRenderer extends TileEntitySpecialRenderer {

	ModelCocaineTrace model = new ModelCocaineTrace();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		renderCocaineTraceModelAt(d0, d1, d2, f);

	}

	private void renderCocaineTraceModelAt(double d, double d1, double d2,
			float f) {

		// directory of the model's texture file
		// bindTexture(new ResourceLocation(""));
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		// GL11.glTranslatef(0.5F, 1.0F, 0.5F);
		model.Shape1.render(0.0625F);
		model.Shape2.render(0.0625F);
		model.Shape3.render(0.0625F);
		model.Shape4.render(0.0625F);
		model.Shape5.render(0.0625F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
}