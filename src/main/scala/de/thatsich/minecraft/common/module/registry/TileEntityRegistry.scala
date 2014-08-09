package de.thatsich.minecraft
package common
package module
package registry


import appeng.api.AEApi
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.log.Log
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class TileEntityRegistry(log: Log)
{
	def registerTileEntities(registrable: Modules): Unit =
	{
		registrable.foreach
		{
			case te: Class[TileEntity] => this.registerTileEntity(te)
			case _                     =>
		}
	}

	private def registerTileEntity(tileEntity: Class[TileEntity]): Unit =
	{
		this.log.info(s"Registering TE $tileEntity")
		GameRegistry.registerTileEntity(tileEntity, tileEntity.toString)
		AEApi.instance().registries().moveable().whiteListTileEntity(tileEntity)
	}
}
