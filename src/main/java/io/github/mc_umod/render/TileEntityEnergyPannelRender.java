package io.github.mc_umod.render;

import java.awt.*;

import io.github.mc_umod.corelib.util.*;
import io.github.mc_umod.tileentity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.tileentity.*;

public class TileEntityEnergyPannelRender extends TileRender {
	
	public TileEntityEnergyPannelRender(GLHelper help) {
		super(help);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity ent, double posX, double posY, double posZ) {
		TileEntityEnergyPannel tile = (TileEntityEnergyPannel) ent;
		if (tile.hasBlockPos()) {
			float f = 1.6F;
			float f1 = 0.016666668F * f;
			GlStateManager.pushMatrix();
			GlStateManager.translate((float) posX, (float) posY + 2, (float) posZ);
			GlStateManager.scale(-f1, -f1, f1);
			GlStateManager.disableLighting();
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			GlStateManager.disableTexture2D();
			this.help.drawGradientRectWithMultiplier(0, -40, 120, 40, new RGBA(Color.CYAN), new RGBA(Color.CYAN).setAlpha(155), 1D, 0.01D);
			GlStateManager.rotate(180F, 0F, 0F, 1.0F);
			this.help.drawGradientRectWithMultiplier(37, -40, 120, 40, new RGBA(Color.CYAN), new RGBA(Color.CYAN).setAlpha(155), 1D, 0.01D);
			GlStateManager.rotate(180F, 0F, 1.0F, 0);
			GlStateManager.rotate(180F, 0F, 0F, 1.0F);
			this.help.drawGradientRect(0D, -40D, 37D, 40D, new RGBA(Color.CYAN).setAlpha(155), new RGBA(Color.CYAN).setAlpha(155), -1D);
			GlStateManager.rotate(180F, 1.0F, 0F, 0F);
			this.help.drawGradientRect(0D, -40D, 37D, 40D, new RGBA(Color.CYAN).setAlpha(155), new RGBA(Color.CYAN).setAlpha(155), 1D);
			GlStateManager.enableLighting();
			GlStateManager.disableBlend();
			GlStateManager.enableTexture2D();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.popMatrix();
		}
	}
	
}
