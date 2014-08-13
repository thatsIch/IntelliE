package de.thatsich.minecraft.common.module.craftrecipe


import scala.collection._


/**
 *
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
trait CraftRecipeStorage[T <: CraftRecipe]
{
	private[this] val internalStorage = mutable.Set[T]()

	def addCraftRecipe(craftRecipe: T): Unit =
	{
		this.internalStorage.add(craftRecipe)
	}
}
