package de.thatsich.minecraft.api.mod.module

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
trait Module
{
	val item      : Option[ Item ]
	val block     : Option[ Block ]
	val tileEntity: Option[ TileEntity ]
	val entity    : Option[ Entity ]
}
