package io.github.mc_umod.gui.inventory;

import io.github.mc_umod.api.render.*;
import io.github.mc_umod.corelib.util.*;
import io.github.mc_umod.utils.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;

public class BaseSlotOutput extends BaseSlot {
	
	public BaseSlotOutput(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		RGBA n = new RGBA(255, 255, 70, 25);
		RGBA e = new RGBA(255, 255, 70, 255);
		this.setHoverColor(n, n, e, e);
		this.setStringRet(new StringMethod() {
			
			@Override
			public String getString() {
				return "Outputslot\nGives crafted stuff out";
			}
		});
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean canTakeStack(EntityPlayer playerIn) {
		return true;
	}
	
	@Override
	public void onSlotChanged() {
		super.onSlotChanged();
		this.inventory.markDirty();
	}
	
	@Override
	public int getFontColor() {
		return 0x000000;
	}
}
