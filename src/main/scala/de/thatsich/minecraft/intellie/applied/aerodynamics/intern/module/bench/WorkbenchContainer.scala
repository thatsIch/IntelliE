package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{Container, Slot}


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchContainer(player: InventoryPlayer, private val workbench: WorkbenchTileEntity) extends Container
{
	// Hotbar
	for (slotIndex <- 0 to 8)
	{
		this.addSlotToContainer(new Slot(player, slotIndex, 8 + 19 * slotIndex, 128))
	}

	// Bag
	for (row <- 0 to 2; col <- 0 to 8)
	{
		this.addSlotToContainer(new Slot(player, col + row * 9 + 9, 8 + 18 * col, 70 + row * 18))
	}

	def canInteractWith(player: EntityPlayer): Boolean = workbench.isUseableByPlayer(player)
}
