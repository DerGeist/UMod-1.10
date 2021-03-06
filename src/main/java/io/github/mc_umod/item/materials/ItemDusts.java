package io.github.mc_umod.item.materials;

import java.util.*;

import io.github.mc_umod.enumtype.*;
import io.github.mc_umod.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;

public class ItemDusts extends ItemBase {
	
	public ItemDusts() {
		super();
		this.hasSubtypes = true;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		EnumTypeBaseStuff type = EnumTypeBaseStuff.byMetadata(stack.getMetadata());
		return "item.dust" + type.getName();
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs creativetab, List list) {
		for (int i = 0; i < EnumTypeBaseStuff.values().length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
}
