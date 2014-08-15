package de.thatsich.minecraft.common.module.container


import de.thatsich.minecraft.common.module.container.slot.BaseSlot
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{Container, Slot}
import net.minecraft.item.ItemStack


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

	override def transferStackInSlot(player: EntityPlayer, slotIndex: Int): ItemStack =
	{
		var resultStack: ItemStack = null
		val clickedSlot = this.getSlot(slotIndex)

		if (clickedSlot != null && clickedSlot.getHasStack)
		{
			val clickedStack = clickedSlot.getStack
			resultStack = clickedStack.copy()

			// in inventory
			if (slotIndex < 36)
			{
				val machineInventorySize = this.inventorySlots.size()
				for (machineSlotIndex <- 36 until machineInventorySize)
				{
					val machineSlot = this.getBaseSlot(machineSlotIndex)
					if (machineSlot != null & !machineSlot.getHasStack && machineSlot.isItemValid(clickedStack))
					{
						val limit = machineSlot.getSlotStackLimit
						if (clickedStack.stackSize > limit)
						{
							val splitStack: ItemStack = clickedStack.splitStack(limit)
							if (!this.mergeItemStack(splitStack, machineSlotIndex, machineSlotIndex + 1, true))
							{
								return null
							}
						}
						else
						{
							if (!this.mergeItemStack(clickedStack, 36, machineInventorySize, true))
							{
								return null
							}
						}
					}
				}
			}

			// in machine
			else
			{
				if (!this.mergeItemStack(clickedStack, 0, 36, false))
				{
					return null
				}
			}

			if (clickedStack.stackSize == 0)
			{
				clickedSlot.putStack(null)
			}
			else
			{
				clickedSlot.onSlotChanged()
			}
		}

		resultStack
	}

	override def retrySlotClick(p_75133_1_ : Int, p_75133_2_ : Int, p_75133_3_ : Boolean, player: EntityPlayer): Unit =
	{}
}
