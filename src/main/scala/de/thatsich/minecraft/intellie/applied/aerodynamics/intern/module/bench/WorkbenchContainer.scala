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
import de.thatsich.minecraft.common.module.container.slot.SlotSide.SlotSide
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client.{InputSlot, UpgradeSlot}
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.ICrafting

import scala.collection.JavaConversions._


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchContainer(player: InventoryPlayer, workbench: WorkbenchTileEntity, log: Log, side: SlotSide) extends BaseContainer
{
	this.bindPlayerInventory(player, 0, 94)

	// Workbench
	this.addSlotToContainer(new InputSlot(player.player, workbench, 0, 39, 40, side))
	this.addSlotToContainer(new UpgradeSlot(player.player, workbench, 1, 59, 40, side))
	this.addSlotToContainer(new OutputSlot(player.player, workbench, 2, 110, 40, side))

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
}
