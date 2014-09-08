package de.thatsich.minecraft.intellie.applied.aerodynamics.module.suite


import de.thatsich.minecraft.intellie.common.Module
import net.minecraft.item.{Item, ItemStack}


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait FreeRunnerModule extends Module
{
	val item: Item

	val stack: ItemStack
}
