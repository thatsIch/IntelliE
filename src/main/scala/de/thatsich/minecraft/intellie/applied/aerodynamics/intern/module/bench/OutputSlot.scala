package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack


/**
 * You can take items out
 * but not insert them manually
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class OutputSlot(inv: IInventory, id: Int, x: Int, y: Int) extends AdvancedSlot(inv, id, x, y)
{
	override def isItemValid(is : ItemStack): Boolean = false
}
