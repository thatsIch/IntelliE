package de.thatsich.minecraft.core.module.item

import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.core.module.ARecipe
import net.minecraft.init.Blocks
import net.minecraft.item.ItemBlock

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AItemBlock( info: AItemInfo, config: Config, recipe: ARecipe )
	extends ItemBlock( Blocks.dirt )
{


}
