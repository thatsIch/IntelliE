package de.thatsich.minecraft.intellie.common.module.tileentities

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
	def register(config: Configuration)

	def getTileEntityID: String
}