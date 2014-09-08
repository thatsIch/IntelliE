package de.thatsich.minecraft.intellie.applied.aerodynamics.module.workbench


import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait WorkbenchRegistry
{
	def recipes: Seq[WorkbenchRecipe]

	def addRecipe(recipe: WorkbenchRecipe): Unit

	def recipesForInput(input: ItemStack): Seq[WorkbenchRecipe]
}
