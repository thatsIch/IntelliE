package de.thatsich.minecraft.common.module.container


import de.thatsich.minecraft.common.module.container.slot.BaseSlot
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.inventory.{Container, Slot}


/**
 *
 *
 * @author thatsIch
 * @since 14.08.2014.
 */
abstract class BaseContainer extends Container
{
	//	override def getSlot(slotIndex : Int): Slot = this.inventorySlots.get(slotIndex).asInstanceOf[AdvancedSlot]

	def getBaseSlot(slotIndex: Int): BaseSlot = this.inventorySlots.get(slotIndex).asInstanceOf[BaseSlot]

	protected def bindPlayerInventory(player: InventoryPlayer, offsetX: Int, offsetY: Int): Unit =
	{
		// Bag
		for (row <- 0 to 2; col <- 0 to 8)
		{
			this.addSlotToContainer(new Slot(player, col + row * 9 + 9, 8 + 18 * col + offsetX, offsetY + row * 18))
		}

		// Hotbar
		for (col <- 0 to 8)
		{
			this.addSlotToContainer(new Slot(player, col, 8 + 18 * col + offsetX, 58 + offsetY))
		}
	}
}
