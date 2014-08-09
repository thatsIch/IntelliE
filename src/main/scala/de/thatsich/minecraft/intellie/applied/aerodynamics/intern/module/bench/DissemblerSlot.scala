package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import net.minecraft.init.Blocks
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class DissemblerSlot(inventory: IInventory, id: Int, x: Int, y: Int) extends Slot(inventory, id, x, y)
{
	override def isItemValid(stack: ItemStack): Boolean =
	{
		// TODO making it for dissembler
		stack.isItemEqual(new ItemStack(Blocks.anvil))
	}
}
