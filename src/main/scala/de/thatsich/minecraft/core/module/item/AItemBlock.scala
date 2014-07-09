package de.thatsich.minecraft.core.module.item

import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.api.mod.module.Recipe
import net.minecraft.init.Blocks
import net.minecraft.item.ItemBlock

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AItemBlock( info: AItemInfo, config: Config, recipe: Recipe )
	extends ItemBlock( Blocks.dirt )
{


}
