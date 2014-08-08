package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.common.module.block.BaseBlock
import de.thatsich.minecraft.common.module.gui.BlockGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity


/**
 * Handles the creation of the needed elements depending
 * if its server or client side
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
trait WorkbenchGuiHandler extends BaseBlock with BlockGuiHandler
{
	def getServerGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		tile match
		{
			case workbench: WorkbenchTileEntity => new WorkbenchContainer(player.inventory, workbench)
			case _                              =>
				this.log.warn(s"Handler $this was used with TE $tile")
				null
		}
	}

	def getClientGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		tile match
		{
			case workbench: WorkbenchTileEntity => new WorkbechGui(player.inventory, workbench)
			case _                              =>
				this.log.warn(s"Handler $this was used with TE $tile")
				null
		}
	}
}
