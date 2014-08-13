package de.thatsich.minecraft
package common
package module
package registry


import appeng.api.AEApi
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.log.Log
import net.minecraft.tileentity.TileEntity


/**
 * Registry for TileEntities.
 * Uses modules to load the TEs
 * You can load single TEs too
 * Acts as a wrapper if API will ever change
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class TileEntityRegistry(registrable: Seq[Module], log: Log)
{
	/**
	 * Registers all tile entites of the module
	 */
	def registerAll(): Unit =
	{
		for (module: Module <- this.registrable; te <- module.tiles)
		{
			this.register(te)
		}
	}

	/**
	 * Registers a single tile entity into the game registry and SIO
	 *
	 * @param teClass class of the tile entity
	 */
	private def register(teClass: Class[_ <: TileEntity]): Unit =
	{
		this.log.info(s"Registering TE $teClass")
		GameRegistry.registerTileEntity(teClass, teClass.toString)
		AEApi.instance().registries().moveable().whiteListTileEntity(teClass)
	}
}
