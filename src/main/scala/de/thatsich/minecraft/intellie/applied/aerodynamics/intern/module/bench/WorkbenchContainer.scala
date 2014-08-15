package de.thatsich.minecraft
package intellie
package applied
package aerodynamics
package intern
package module
package bench


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.container.BaseContainer
import de.thatsich.minecraft.common.module.container.slot.OutputSlot
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client.{ArmorDissemblerSlot, UpgradeSlot}
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{ICrafting, Slot}
import net.minecraft.item.ItemStack

import scala.collection.JavaConversions._


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchContainer(player: InventoryPlayer, workbench: WorkbenchTileEntity, log: Log) extends BaseContainer
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
	this.addSlotToContainer(new UpgradeSlot(player.player, workbench, 1, 59, 40))
	this.addSlotToContainer(new OutputSlot(player.player, workbench, 2, 110, 40))

	def canInteractWith(player: EntityPlayer): Boolean = workbench.isUseableByPlayer(player)

	@SideOnly(Side.CLIENT)
	override def updateProgressBar(id: Int, data: Int): Unit =
	{
		if (id == 0)
		{
			this.workbench.modificationTime = data
		}
	}

	override def addCraftingToCrafters(crafter: ICrafting): Unit =
	{
		super.addCraftingToCrafters(crafter)

		crafter.sendProgressBarUpdate(this, 0, this.workbench.modificationTime)
	}

	private var lastModificationTime = 0

	override def detectAndSendChanges(): Unit =
	{
		super.detectAndSendChanges()

		val crafters = this.crafters.toList.asInstanceOf[List[ICrafting]]
		for (crafter <- crafters)
		{
			if (this.lastModificationTime != this.workbench.modificationTime)
			{
				crafter.sendProgressBarUpdate(this, 0, this.workbench.modificationTime)
			}
		}

		this.lastModificationTime = this.workbench.modificationTime
	}

	override def transferStackInSlot(player: EntityPlayer, slotIndex: Int): ItemStack =
	{
		val clickedSlot: Slot = this.getSlot(slotIndex)
		this.log.debug(s"Player $player clicked Slot $clickedSlot with index $slotIndex.")

		// check if clickedSlot really exists and has something in it
		if (clickedSlot != null && clickedSlot.getHasStack)
		{
			this.log.debug("Slot exists and has an itemstack.")
			val stackInSlot: ItemStack = clickedSlot.getStack
			val result: ItemStack = stackInSlot.copy()

			// input and upgrade clickedSlot
			if (slotIndex >= 36)
			{
				this.log.debug("In workbench inventory.")

				val hasStackMerged = this.mergeItemStack(stackInSlot, 0, 35, false)
				val stackIsNull = stackInSlot == null
				val stackSize = stackInSlot.stackSize
				this.log.debug(s"Stack has merged: $hasStackMerged")
				this.log.debug(s"Stack is null: $stackIsNull")
				this.log.debug(s"Stack size: $stackSize")

				if (!hasStackMerged) return null

				this.log.debug("Merged inventory.")
			}
			// in player inventory
			else if (slotIndex < 36 && this.transferFromInventoryToWorkbench(stackInSlot))
			{
				return null
			}

			this.log.debug("Stacksize: " + stackInSlot.stackSize)
			if (stackInSlot.stackSize == 0) clickedSlot.putStack(null)

			clickedSlot.onSlotChanged()

			return result
		}

		null
	}

	private def transferFromInputToInventory(): Unit =
	{
	}

	private def transferFromInventoryToWorkbench(stackInSlot: ItemStack): Boolean = {
		this.log.debug("In player inventory.")
		val inputSlot: Slot = this.getSlot(36)
		val upgradeSlot: Slot = this.getSlot(37)

		val isInputValid = inputSlot.isItemValid(stackInSlot)
		val isUpgradeValid = upgradeSlot.isItemValid(stackInSlot)
		this.log.debug(s"Input is valid: $isInputValid")
		this.log.debug(s"Upgrade is valid: $isUpgradeValid")

		if (isInputValid && !this.mergeItemStack(stackInSlot, 36, 37, false)) return true
		else if (isUpgradeValid && !this.mergeItemStack(stackInSlot, 37, 38, false)) return true
		this.log.debug("Merged inventory.")

		false
	}
}
