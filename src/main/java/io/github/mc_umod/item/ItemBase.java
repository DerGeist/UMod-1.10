package io.github.mc_umod.item;

import java.util.*;

import io.github.mc_umod.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.relauncher.*;

public abstract class ItemBase extends Item {
	
	public ItemBase() {
		this.setCreativeTab(UReference.things);
	}
		
}
