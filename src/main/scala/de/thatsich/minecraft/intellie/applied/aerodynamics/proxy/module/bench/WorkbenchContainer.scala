package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench

import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseContainer
import de.thatsich.minecraft.common.module.container.OutputSlot
import de.thatsich.minecraft.common.module.container.SlotSide.SlotSide
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.client.{InputSlot, UpgradeSlot}
import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.ICrafting

import scala.collection.convert.Wrappers.JListWrapper


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

	private var lastModificationTime = 0

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

	override def detectAndSendChanges(): Unit =
	{
		super.detectAndSendChanges()

		val wrapper = new JListWrapper(this.crafters)
		val crafters = wrapper.asInstanceOf[List[ICrafting]]
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
