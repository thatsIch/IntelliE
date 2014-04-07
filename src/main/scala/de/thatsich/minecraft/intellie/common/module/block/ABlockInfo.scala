package de.thatsich.minecraft.intellie.common.module.block

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.block.material.Material
import net.minecraft.block.Block

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ABlockInfo(blockName: String, texture: String, hardness: Float, mat: Material, blockSound: Block.SoundType, creativeTab: CreativeTabs)
{
	def getName: String =
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

	def getTexture: String =
	{
		this.texture
	}
}