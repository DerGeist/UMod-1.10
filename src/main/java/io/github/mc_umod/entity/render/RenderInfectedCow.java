package io.github.mc_umod.entity.render;

import io.github.mc_umod.*;
import io.github.mc_umod.entity.*;
import io.github.mc_umod.entity.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.client.registry.*;
import net.minecraftforge.fml.relauncher.*;

@SideOnly(Side.CLIENT)
public class RenderInfectedCow extends RenderLiving<EntityInfectedCow> implements IRenderFactory<EntityInfectedCow> {
	
	public RenderInfectedCow(RenderManager r) {
		super(r, new ModelInfectedCow(), 0);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityInfectedCow entity) {
		return new ResourceLocation(UReference.resource + "textures/entity/InfectedCow.png");
	}
	
	@Override
	public Render<? super EntityInfectedCow> createRenderFor(RenderManager manager) {
		return new RenderInfectedCow(manager);
	}
}
