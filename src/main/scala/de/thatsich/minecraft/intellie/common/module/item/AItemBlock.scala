package de.thatsich.minecraft.intellie.common.module.item

import net.minecraft.item.ItemBlock
import de.thatsich.minecraft.intellie.common.module.{ARecipe, AConfig}
import net.minecraft.init.Blocks

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AItemBlock(info: AItemInfo, config: AConfig, recipe: ARecipe)
	extends ItemBlock(Blocks.dirt)
	with IItemBlock
{


}
