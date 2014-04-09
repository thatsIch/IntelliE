package de.thatsich.minecraft.core.module.block

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.block.material.Material
import net.minecraft.block.Block
import de.thatsich.minecraft.core.module.{ATexture, AName}

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ABlockInfo(blockName: AName, texture: ATexture, hardness: Float, mat: Material, blockSound: Block.SoundType, creativeTab: CreativeTabs)
{
	def getName: AName =
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

	def getTexture: ATexture =
	{
		this.texture
	}
}