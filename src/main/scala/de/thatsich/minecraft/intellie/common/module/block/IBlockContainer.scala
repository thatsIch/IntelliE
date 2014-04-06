package de.thatsich.minecraft.intellie.common.module.block

import net.minecraft.block.ITileEntityProvider

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
trait IBlockContainer extends IBlock with ITileEntityProvider
{
	def getItemBlockClass: Class[ _ => IItemBlock ]
}
