package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.common.module.container.slot.OutputSlot
import net.minecraft.client.Minecraft
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
		this.addSlotToContainer(new Slot(player, slotIndex, 8 + 18 * slotIndex, 152))
	}

	// Bag
	for (row <- 0 to 2; col <- 0 to 8)
	{
		this.addSlotToContainer(new Slot(player, col + row * 9 + 9, 8 + 18 * col, 94 + row * 18))
	}

	// Workbench
	this.addSlotToContainer(new ArmorDissemblerSlot(workbench, 0, 39, 40))
	this.addSlotToContainer(new UpgradeSlot(workbench, 1, 59, 40))
	this.addSlotToContainer(new OutputSlot(workbench, 2, 110, 40))

	def canInteractWith(player: EntityPlayer): Boolean = workbench.isUseableByPlayer(player)

	override def transferStackInSlot(player: EntityPlayer, i: Int): ItemStack =
	{
		null
	}
}
