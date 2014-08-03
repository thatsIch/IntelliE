package de.thatsich.minecraft.api.mod.module.item

import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.api.mod.module.recipe.Recipe
import net.minecraft.init.Blocks
import net.minecraft.item.ItemBlock

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseItemBlock( info: BaseItemInfo, config: Config, recipe: Recipe ) extends ItemBlock( Blocks.dirt )