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
class TileEntityRegistry(registrable: Seq[Class[_ <: TileEntity]], log: Log)
{
	/**
	 * Registers all tile entites of the module
	 */
	def registerAll(): Unit =
	{
		this.registrable.foreach(this.register)
		this.log.info(s"Finished loading ${this.registrable.length} tile(s).")
	}

	/**
	 * Registers a single tile entity into the game registry and SIO
	 *
	 * @param teClass class of the tile entity
	 */
	private def register(teClass: Class[_ <: TileEntity]): Unit =
	{
		val simpleClassName: String = teClass.getSimpleName

		this.log.debug(s"Registering tile $simpleClassName")
		GameRegistry.registerTileEntity(teClass, teClass.toString)
		AEApi.instance().registries().moveable().whiteListTileEntity(teClass)
	}
}
