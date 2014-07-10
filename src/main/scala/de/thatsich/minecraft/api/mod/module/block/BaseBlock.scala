package de.thatsich.minecraft.api.mod.module.block

import net.minecraft.block.Block

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseBlock( info: BlockInfo, config: BlockConfig )
	extends Block( info.material )
{
	this.setBlockName( info.blockName )
	this.setHardness( info.hardness )
	this.setBlockTextureName( info.texture )
	this.setCreativeTab( info.creativeTab )
}
