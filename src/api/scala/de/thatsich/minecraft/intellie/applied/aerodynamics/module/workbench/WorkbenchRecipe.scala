package de.thatsich.minecraft.intellie.applied.aerodynamics.module.workbench


import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait WorkbenchRecipe
{
	// to be modified item
	val input: ItemStack

	// item consumed to upgrade input
	val upgrade: ItemStack

	// fake modifier item to set NBT attribute on input. Size determines the value
	val modifier: ItemStack

	// output of the recipe
	val output: ItemStack

	val energycost: Double

	val time: Int
}
