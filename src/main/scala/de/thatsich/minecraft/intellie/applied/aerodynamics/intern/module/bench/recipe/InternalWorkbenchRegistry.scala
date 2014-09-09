package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.recipe


import de.thatsich.minecraft.intellie.applied.aerodynamics.module.workbench.{WorkbenchRecipe, WorkbenchRegistry}
import net.minecraft.item.ItemStack

import scala.collection.mutable


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
class InternalWorkbenchRegistry extends WorkbenchRegistry
{
	private val workbenchrecipes = mutable.ArrayBuffer[WorkbenchRecipe]()

	override def recipes: Seq[WorkbenchRecipe] = this.workbenchrecipes.toSeq

	override def recipesForInput(input: ItemStack): Seq[WorkbenchRecipe] =
	{
		val result = mutable.ArrayBuffer[WorkbenchRecipe]()

		this.workbenchrecipes.foreach(recipe =>
		{
			if (recipe.input.isItemEqual(input)) result += recipe
		})

		result.toSeq
	}

	override def addRecipe(recipe: WorkbenchRecipe): Unit = this.workbenchrecipes += recipe
}
