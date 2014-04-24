package de.thatsich.minecraft.core.module

import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity

/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
trait IModule
{
	def item: Option[ Item ]

	def block: Option[ Block ]

	def tileEntity: Option[ TileEntity ]

	def entity: Option[ Entity ]
}
