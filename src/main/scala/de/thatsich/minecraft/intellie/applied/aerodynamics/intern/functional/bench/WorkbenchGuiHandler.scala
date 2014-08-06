package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench

import cpw.mods.fml.common.network.{IGuiHandler, NetworkRegistry}
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

/**
 * TODO can only have one per mod
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class WorkbenchGuiHandler extends IGuiHandler
{
	NetworkRegistry.INSTANCE.registerGuiHandler( AppliedAerodynamics, this )

	def getServerGuiElement( ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int ): AnyRef =
	{
		ID match
		{
			case 0 =>
				world.getTileEntity( x, y, z ) match
				{
					case workbench: WorkbenchTileEntity => new WorkbenchContainer( player.inventory, workbench )
				}
		}
	}

	def getClientGuiElement( ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int ): AnyRef =
	{
		ID match
		{
			case 0 =>
				world.getTileEntity( x, y, z ) match
				{
					case workbench: WorkbenchTileEntity => new WorkbechGui(player.inventory, workbench)
				}
		}
	}
}
