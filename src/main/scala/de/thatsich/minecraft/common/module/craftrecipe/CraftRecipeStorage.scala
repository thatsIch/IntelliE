package de.thatsich.minecraft.common.module.craftrecipe


/**
 *
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
trait CraftRecipeStorage[T <: CraftRecipe]
{
	def addCraftRecipe(craftRecipe: T): Unit
}
