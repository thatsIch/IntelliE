package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{Container, Slot}
import net.minecraft.item.ItemStack


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
		this.addSlotToContainer(new Slot(player, slotIndex, 8 + 18 * slotIndex, 128))
	}

	// Bag
	for (row <- 0 to 2; col <- 0 to 8)
	{
		this.addSlotToContainer(new Slot(player, col + row * 9 + 9, 8 + 18 * col, 70 + row * 18))
	}

	// Workbench
	this.addSlotToContainer(new Slot(workbench, 0, 39, 13))
	this.addSlotToContainer(new Slot(workbench, 1, 59, 13))
	this.addSlotToContainer(new OutputSlot(workbench, 2, 110, 13))
	this.addSlotToContainer(new DissemblerSlot(workbench, 3, 39, 43))
	this.addSlotToContainer(new Slot(workbench, 4, 59, 43))
	this.addSlotToContainer(new OutputSlot(workbench, 5, 110, 43))

	def canInteractWith(player: EntityPlayer): Boolean = workbench.isUseableByPlayer(player)

	override def transferStackInSlot(player: EntityPlayer, i: Int): ItemStack =
	{
		null
	}
}
