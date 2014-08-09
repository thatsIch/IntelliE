package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.DissemblerItem
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack


/**
 * A slot distinctive for dissemblers
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class DissemblerSlot(inventory: IInventory, id: Int, x: Int, y: Int) extends Slot(inventory, id, x, y)
{
	override def isItemValid(stack: ItemStack): Boolean =
	{
		stack.getItem.isInstanceOf[DissemblerItem]
	}
}
