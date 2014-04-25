package de.thatsich.minecraft.core.module.block

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ABlock( info: ABlockInfo, config: ABlockConfig )
	extends Block( info.getMaterial )
	        with IBlock
{
	val name       : String       = info.getName
	val hardness   : Float        = info.getHardness
	val creativeTab: CreativeTabs = info.getCreativeTab
	val texture    : String       = info.getTexture

	this.setBlockName( name )
	this.setHardness( hardness )
	this.setBlockTextureName( texture )
	this.setCreativeTab( creativeTab )
}
