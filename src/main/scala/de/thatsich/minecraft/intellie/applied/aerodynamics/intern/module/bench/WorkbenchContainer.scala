package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.Container


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchContainer(player: InventoryPlayer, private val workbench: WorkbenchTileEntity) extends Container
{
	def canInteractWith(player: EntityPlayer): Boolean = workbench.isUseableByPlayer(player)
}
