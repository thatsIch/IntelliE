package de.thatsich.minecraft.common.proxy.module.craftrecipe


import scala.collection._


/**
 *
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
trait CraftRecipeStorage[T <: CraftRecipe]
{
	val internalCraftRecipes = mutable.Set[T]()
}
