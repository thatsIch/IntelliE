package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import net.minecraft.item.ItemStack

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
private[ chest ] trait TAeroChestItemStack
{
	self: ItemAeroChest =>

	val itemStack: ItemStack = new ItemStack(this)
}
