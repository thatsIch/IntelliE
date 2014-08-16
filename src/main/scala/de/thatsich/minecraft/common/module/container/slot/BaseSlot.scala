package de.thatsich.minecraft
package common
package module
package container
package slot


import de.thatsich.minecraft.common.module.container.slot.SlotSide.SlotSide
import de.thatsich.minecraft.common.module.container.slot.SlotStateWTF.SlotState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class BaseSlot(player: EntityPlayer, inv: IInventory, id: Int, x: Int, y: Int, val state: SlotState, val side: SlotSide) extends Slot(inv, id, x, y)
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

	def isClientSide: Boolean = this.side == SlotSide.Client

	def isServerSide: Boolean = this.side == SlotSide.Server
}

