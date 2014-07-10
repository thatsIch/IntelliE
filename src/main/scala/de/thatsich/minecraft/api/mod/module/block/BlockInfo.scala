package de.thatsich.minecraft.api.mod.module.block

import de.thatsich.minecraft.api.mod.module.{BaseName, BaseTexture}
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

/**
 *
 *
 * @author thatsIch
 * @since 10.07.2014.
 */
trait BlockInfo
{
	val blockName  : BaseName
	val texture    : BaseTexture
	val hardness   : Float
	val material   : Material
	val blockSound : Block.SoundType
	val creativeTab: CreativeTabs
}
