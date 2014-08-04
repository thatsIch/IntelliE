package de.thatsich.minecraft.common.module.registries

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.module.Module
import net.minecraft.tileentity.TileEntity

/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
trait TileEntityRegistry
{
	def registerTileEntities( modules: Seq[ Module ] ): Unit =
	{
		for( module <- modules )
		{
			module.moduleParts.foreach
			{
				case te: TileEntity => this.registerTileEntity( te )
				case _ =>
			}
		}
	}

	private def registerTileEntity( tileEntity: TileEntity ): Unit =
	{
		GameRegistry.registerTileEntity( tileEntity.getClass, tileEntity.getClass.toString )
	}
}
