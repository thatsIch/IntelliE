package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench


import de.thatsich.minecraft.common.module.registries.ModuleGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World


/**
 * Handles the creation of the needed elements depending
 * if its server or client side
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchGuiHandler extends ModuleGuiHandler
{
	//	NetworkRegistry.INSTANCE.registerGuiHandler( AppliedAerodynamics, this )

	def getServerGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		new WorkbenchContainer(player.inventory, tile.asInstanceOf[WorkbenchTileEntity])
	}

	def getClientGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		new WorkbechGui(player.inventory, tile.asInstanceOf[WorkbenchTileEntity])
	}
}
