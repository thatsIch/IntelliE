package de.thatsich.minecraft.core.module.tileentities

import net.minecraftforge.common.config.Configuration

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
/**
  */
trait ITileEntity
{
	def register( config: Configuration ): Unit

	def getTileEntityID: String
}