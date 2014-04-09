package de.thatsich.minecraft.core.registries

import net.minecraft.tileentity.TileEntity
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.core.module.tileentities.ITileEntity
import de.thatsich.minecraft.core.log.ILog

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
