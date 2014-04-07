package de.thatsich.minecraft.intellie.common.module.block

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import de.thatsich.minecraft.intellie.common.registries.BlockRegistry

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ABlock(info: ABlockInfo, config: ABlockConfig, blocks: BlockRegistry) extends Block(info.getMaterial) with IBlock
{
	val blockName: Nothing = info.getName
	val name: Nothing = blockName.getUnlocalizedName
	val hardness: Float = info.getHardness
	val creativeTab: CreativeTabs = info.getCreativeTab
	val texture: Nothing = info.getTexture.getTexture
	this.setBlockName(name)
	this.setHardness(hardness)
	this.setBlockTextureName(texture)
	this.setCreativeTab(creativeTab)
	blocks.add(this)
}
