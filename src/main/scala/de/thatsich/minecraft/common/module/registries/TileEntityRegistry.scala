package de.thatsich.minecraft.common.module.registries


import appeng.api.AEApi
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.Modules
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class TileEntityRegistry
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
		GameRegistry.registerTileEntity(tileEntity, tileEntity.toString)
		AEApi.instance().registries().moveable().whiteListTileEntity(tileEntity)
	}
}
