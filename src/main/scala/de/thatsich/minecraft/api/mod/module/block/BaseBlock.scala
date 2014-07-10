package de.thatsich.minecraft.api.mod.module.block

import net.minecraft.creativetab.CreativeTabs

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseBlock( info: BaseBlockInfo, config: BaseBlockConfig )
	extends Block( info.getMaterial )
	        with Block
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
