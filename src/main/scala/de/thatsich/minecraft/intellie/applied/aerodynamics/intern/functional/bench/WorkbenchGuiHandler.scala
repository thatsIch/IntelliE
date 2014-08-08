package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench


import de.thatsich.minecraft.common.module.registries.BlockGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity


/**
 * Handles the creation of the needed elements depending
 * if its server or client side
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
trait WorkbenchGuiHandler extends BlockGuiHandler
{
	def getServerGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		new WorkbenchContainer(player.inventory, tile.asInstanceOf[WorkbenchTileEntity])
	}

	def getClientGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		new WorkbechGui(player.inventory, tile.asInstanceOf[WorkbenchTileEntity])
	}
}
