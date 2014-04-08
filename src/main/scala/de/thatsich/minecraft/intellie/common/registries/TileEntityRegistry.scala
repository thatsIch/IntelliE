package de.thatsich.minecraft.intellie.common.registries

import net.minecraft.tileentity.TileEntity
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.intellie.common.logger.ILog
import de.thatsich.minecraft.intellie.common.module.tileentities.ITileEntity

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class TileEntityRegistry(log: ILog)
	extends ARegistry[ ITileEntity ](log)
{
	def register()
	{
		for( tileEntity <- this.set )
		{
			val te: TileEntity = tileEntity.asInstanceOf[ TileEntity ]
			val tileEntityClass = te.getClass
			val tileEntityKey = tileEntity.getTileEntityID
			GameRegistry.registerTileEntity(tileEntityClass, tileEntityKey)
		}
	}
}
