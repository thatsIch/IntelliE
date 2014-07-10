package de.thatsich.minecraft.api.mod.module.block

import net.minecraft.block.ITileEntityProvider
import net.minecraft.item.ItemBlock

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
trait BlockContainer extends Block with ITileEntityProvider
{
	def getItemBlockClass: Class[ _ <: ItemBlock ]
}
