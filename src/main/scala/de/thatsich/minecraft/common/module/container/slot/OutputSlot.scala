package de.thatsich.minecraft.common.module.container.slot


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
class OutputSlot(player: EntityPlayer, inv: IInventory, id: Int, x: Int, y: Int) extends AdvancedSlot(player, inv, id, x, y)
{
	override def isItemValid(is: ItemStack): Boolean = false
}
