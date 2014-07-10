package de.thatsich.minecraft.api.mod.module.tileentity

import net.minecraftforge.common.config.Configuration

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
/**
  */
trait TileEntity
{
	def register( config: Configuration ): Unit

	val category    : String
	val key         : String
	val tileEntityID: String
}