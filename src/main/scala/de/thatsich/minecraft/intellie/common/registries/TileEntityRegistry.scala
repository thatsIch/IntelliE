package de.thatsich.minecraft.intellie.common.registries

import net.minecraft.tileentity.TileEntity
import cpw.mods.fml.common.registry.GameRegistry

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class TileEntityRegistry
{
	def register()
	{
		for( tileEntity <- this.tileEntities )
		{
			val te: TileEntity = tileEntity.asInstanceOf[ TileEntity ]
			val tileEntityClass = te.getClass
			val tileEntityKey = tileEntity.getTileEntityID
			GameRegistry.registerTileEntity(tileEntityClass, tileEntityKey)
		}
	}
}
