package de.thatsich.minecraft.core.module.tileentities

import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.config.Configuration

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ATileEntity(category: String, key: String, tileEntityID: String) extends TileEntity with ITileEntity
{
	def getCategory: String =
	{
		this.category
	}

	def getKey: String =
	{
		this.key
	}

	def register(config: Configuration)

	def getTileEntityID: String =
	{
		this.tileEntityID
	}
}