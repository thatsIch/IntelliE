package de.thatsich.minecraft.intellie.common.module.block

import net.minecraft.block.Block
import de.thatsich.minecraft.intellie.common.registries.BlockRegistry
import de.thatsich.minecraft.intellie.common.module.AName
import net.minecraft.creativetab.CreativeTabs

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ABlock(info: ABlockInfo, config: ABlockConfig, blocks: BlockRegistry)
	extends Block(info.getMaterial) with IBlock
{
	val blockName: AName = info.getName
	val name: String = blockName.getUnlocalizedName
	val hardness: Float = info.getHardness
	val creativeTab: CreativeTabs = info.getCreativeTab
	val texture: String = info.getTexture.toString

	this.setBlockName(name)
	this.setHardness(hardness)
	this.setBlockTextureName(texture)
	this.setCreativeTab(creativeTab)

	blocks.add(this)
}
