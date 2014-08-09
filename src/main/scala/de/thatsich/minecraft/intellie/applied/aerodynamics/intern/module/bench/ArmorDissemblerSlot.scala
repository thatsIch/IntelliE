package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.common.item.AAEPoweredItemArmor
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.DissemblerItem
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack


/**
 * only accepts powered armor of AppAero
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class ArmorDissemblerSlot(inventory: IInventory, id: Int, x: Int, y: Int) extends Slot(inventory, id, x, y)
{
	override def isItemValid(stack: ItemStack): Boolean =
	{
		stack.getItem.isInstanceOf[AAEPoweredItemArmor] ||
		stack.getItem.isInstanceOf[DissemblerItem]
	}
}
