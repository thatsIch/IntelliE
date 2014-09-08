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
	def input: ItemStack

	// item consumed to upgrade input
	def upgrade: ItemStack

	// fake modifier item to set NBT attribute on input. Size determines the value
	def modifier: String

	// output of the recipe
	def output: ItemStack

	// energy cost to modify the input
	def energycost: Double

	// time required to modify the input
	def time: Int
}
