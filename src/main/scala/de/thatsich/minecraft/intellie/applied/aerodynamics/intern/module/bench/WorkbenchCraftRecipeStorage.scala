package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.common.module.craftrecipe.CraftRecipeStorage
import net.minecraft.item.ItemStack

import scala.collection.mutable


/**
 *
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
object WorkbenchCraftRecipeStorage extends WorkbenchCraftRecipeStorage

class WorkbenchCraftRecipeStorage extends CraftRecipeStorage[WorkbenchCraftRecipe]
{
	val internalInputs = mutable.Set[ItemStack]()
	val internalUpgrades = mutable.Set[ItemStack]()
	val internalAttributes = mutable.Set[ItemStack]()
}
