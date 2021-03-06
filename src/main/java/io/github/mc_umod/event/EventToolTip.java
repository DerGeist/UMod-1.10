package io.github.mc_umod.event;

import org.lwjgl.input.*;

import com.mojang.realmsclient.gui.*;

import io.github.mc_umod.block.machine.*;
import io.github.mc_umod.item.*;
import io.github.mc_umod.utils.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class EventToolTip {
	
	@SubscribeEvent
	public void tooltipEvent(ItemTooltipEvent event) {
		if (event.getItemStack() != null && !event.isShowAdvancedItemTooltips()) {
			ItemStack itemStack = event.getItemStack();
			if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey(ItemEnergyDisplay.NBT_TAG)) {
				event.getToolTip().add("Bounded");
			}
			if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey(EventGettingRadiationInv.TAG_MAIN) && ((NBTTagCompound) itemStack.getTagCompound().getTag(EventGettingRadiationInv.TAG_MAIN)).hasKey(EventGettingRadiationInv.TAG_INFECTED)) {
				boolean flag = ((NBTTagCompound) itemStack.getTagCompound().getTag(EventGettingRadiationInv.TAG_MAIN)).getBoolean(EventGettingRadiationInv.TAG_INFECTED);
				event.getToolTip().add((flag ? ChatFormatting.RED : ChatFormatting.GREEN) + "Is Infected " + flag);
			}
			if (Block.getBlockFromItem(itemStack.getItem()) instanceof BlockConduit && itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey(NBTUtils.NBTKEY)) {
				ItemStack flag = NBTUtils.getStackFromConduit(itemStack);
				event.getToolTip().add(flag.getDisplayName());
			}
		}
		ItemStack itemStack = event.getItemStack();
		if (event.getItemStack() != null && Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("NBTS")) {
			NBTTagCompound comp = itemStack.getTagCompound().getCompoundTag("NBTS");
			for (Object str : comp.getKeySet()) {
				event.getToolTip().add((String) str);
			}
		} else if (event.getItemStack() != null && itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("NBTS")) {
			event.getToolTip().add("Press SHIFT for more Informations");
		}
	}
	
}
