package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench

import net.minecraft.entity.player.{InventoryPlayer, EntityPlayer}
import net.minecraft.inventory.Container

/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchContainer(player: InventoryPlayer, private val workbench: WorkbenchTileEntity) extends Container
{
	def canInteractWith( player : EntityPlayer ): Boolean = workbench.isUseableByPlayer(player)
}
