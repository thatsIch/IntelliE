package de.thatsich.intellie.applied.aerodynamics.functionality.chest;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 @author thatsIch
 @since 03.04.2014. */
public class ValidatingSlot extends Slot
{
	public ValidatingSlot( IInventory par1iInventory, int par2, int par3, int par4 )
	{
		super( par1iInventory, par2, par3, par4 );
	}

	@Override
	public boolean isItemValid( ItemStack itemStack )
	{
		return itemStack != null;
	}
}
