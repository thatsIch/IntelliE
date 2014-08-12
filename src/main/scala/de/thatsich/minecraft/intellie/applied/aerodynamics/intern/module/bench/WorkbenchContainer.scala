package de.thatsich.minecraft
package intellie
package applied
package aerodynamics
package intern
package module
package bench


import appeng.api.definitions.{Blocks, Items, Materials}
import appeng.api.{AEApi, IAppEngApi}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.module.container.slot.OutputSlot
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.common.item.AAEPoweredItemArmor
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.DissemblerItem
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{Container, ICrafting, Slot}
import net.minecraft.item.{Item, ItemStack}

import scala.collection.JavaConversions._


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
		val slot: Slot = this.getSlot(slotIndex)

		// check if slot really exists and has something in it
		if (slot != null && slot.getHasStack)
		{
			val stackInSlot: ItemStack = slot.getStack
			val result = stackInSlot.copy

			// armor tool slot
			if (slotIndex >= 36)
			{
				if (!this.mergeItemStack(stackInSlot, 0, 35, false))
				{
					return null
				}
			}
			// in player inventory
			else if (slotIndex < 36)
			{
				val itemInSlot: Item = stackInSlot.getItem
				val api: IAppEngApi = AEApi.instance()
				val apiItems: Items = api.items()
				val apiBlocks: Blocks = api.blocks()
				val apiMats: Materials = api.materials()

				// is armor tool
				if (itemInSlot.isInstanceOf[DissemblerItem] ||
					itemInSlot.isInstanceOf[AAEPoweredItemArmor])
				{
					if (!this.mergeItemStack(stackInSlot, 36, 37, false))
					{
						return null
					}
				}
				// is upgrade
				else if (apiBlocks.blockEnergyCell.sameAs(stackInSlot) ||
					apiBlocks.blockEnergyCellDense.sameAs(stackInSlot) ||
					apiItems.itemCell1k.sameAs(stackInSlot) ||
					apiItems.itemCell4k.sameAs(stackInSlot) ||
					apiItems.itemCell16k.sameAs(stackInSlot) ||
					apiItems.itemCell64k.sameAs(stackInSlot) ||
					apiMats.materialCardSpeed.sameAs(stackInSlot) ||
					apiMats.materialLogicProcessor.sameAs(stackInSlot) ||
					apiMats.materialEngProcessor.sameAs(stackInSlot) ||
					apiMats.materialCalcProcessor.sameAs(stackInSlot))
				{
					val upgradeSlot: Slot = this.getSlot(37)

					if (upgradeSlot != null && upgradeSlot.getHasStack)
					{
						val upgradeStack: ItemStack = upgradeSlot.getStack
						if (upgradeStack.stackSize == 0)
						{
							if (!this.mergeItemStack(stackInSlot, 37, 38, false))
							{
								return null
							}
						}
					}
				}
			}

			if (stackInSlot.stackSize == 0)
			{
				slot.putStack(null)
			}
			else
			{
				slot.onSlotChanged()
			}

			if (stackInSlot.stackSize == result.stackSize)
			{
				return null
			}

			slot.onPickupFromSlot(player, stackInSlot)
		}

		null
	}
}
