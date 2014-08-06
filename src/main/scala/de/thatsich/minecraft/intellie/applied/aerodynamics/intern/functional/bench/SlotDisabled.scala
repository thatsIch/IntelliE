package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack

/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class SlotDisabled(inventory: IInventory, idx: Int, x: Int, y: Int ) extends AdvancedSlot( inventory, idx, x, y )
{
	override def isItemValid( is : ItemStack ): Boolean = false

	override def canTakeStack( p : EntityPlayer ): Boolean = false
}
