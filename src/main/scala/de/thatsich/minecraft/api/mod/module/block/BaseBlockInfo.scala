package de.thatsich.minecraft.api.mod.module.block

import de.thatsich.minecraft.api.mod.module.{BaseName, BaseTexture}
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseBlockInfo( blockName: BaseName, texture: BaseTexture, hardness: Float, mat: Material, blockSound: Block.SoundType, creativeTab: CreativeTabs )
{
	def getName: BaseName =
	{
		this.blockName
	}

	def getBlockSound: Block.SoundType =
	{
		this.blockSound
	}

	def getCreativeTab: CreativeTabs =
	{
		this.creativeTab
	}

	def getMaterial: Material =
	{
		this.mat
	}

	def getHardness: Float =
	{
		this.hardness
	}

	def getTexture: BaseTexture =
	{
		this.texture
	}
}