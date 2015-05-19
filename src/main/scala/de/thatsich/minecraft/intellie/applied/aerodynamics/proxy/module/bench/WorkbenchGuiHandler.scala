package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BlockGuiHandler
import de.thatsich.minecraft.common.proxy.module.container.SlotSide
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.client.WorkbenchGui
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity


/**
 * Handles the creation of the needed elements depending
 * if its server or client side
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchGuiHandler(val name: ID, log: Log, recipeStorage: WorkbenchCraftRecipeStorage) extends BlockGuiHandler
{
	def getServerGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		tile match
		{
			case workbench: WorkbenchTileEntity => new WorkbenchContainer(player.inventory, workbench, this.log, SlotSide.Server, recipeStorage)
			case _                              =>
				this.log.warn(s"Handler $this was used with TE $tile")
				null
		}
	}

	def getClientGuiElement(player: EntityPlayer, tile: TileEntity): AnyRef =
	{
		tile match
		{
			case workbench: WorkbenchTileEntity => new WorkbenchGui(player.inventory, workbench, this.log, this.recipeStorage)
			case _                              =>
				this.log.warn(s"Handler $this was used with TE $tile")
				null
		}
	}
}
