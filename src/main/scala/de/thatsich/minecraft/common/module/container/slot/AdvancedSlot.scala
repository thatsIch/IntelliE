package de.thatsich.minecraft.common.module.container.slot


import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class AdvancedSlot(player: EntityPlayer, inv: IInventory, id: Int, x: Int, y: Int) extends Slot(inv, id, x,y)
{
	override def onPickupFromSlot(player: EntityPlayer, is: ItemStack): Unit =
	{
		this.onCrafting(is)
		super.onPickupFromSlot(player, is)
	}

	override def onCrafting(is: ItemStack): Unit =
	{
		is.onCrafting(this.player.worldObj, this.player, 0)
	}
}
