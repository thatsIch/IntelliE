package de.thatsich.minecraft
package intellie
package applied
package aerodynamics
package intern
package module
package bench


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.block.{BaseBlock, MultiTexture}
import de.thatsich.minecraft.common.string.ID
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchBlock(modid: ID, name: ID, log: Log) extends BaseBlock(modid, name, log)
                                                     with MultiTexture
                                                     with WorkbenchGuiHandler
{
	override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, side: Int, hitX: Float, hitY: Float, p_149727_9_ : Float): Boolean =
	{
		if (!world.isRemote)
		{
			val name = this.getClass.getSimpleName
			val hash = this.getUniqueID(name)

			player.openGui(AppliedAerodynamics, hash, world, x, y, z)
		}

		true
	}

	def createNewTileEntity(world: World, par2int: Int): TileEntity = new WorkbenchTileEntity

	// TODO refactoring to commong
	private def getUniqueID(str: String): Int =
	{
		var h: Int = 0

		for (ch <- str)
		{
			h = 31 * h + ch
		}

		h
	}
}
