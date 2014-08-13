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
class WorkbenchCraftRecipeStorage extends CraftRecipeStorage[WorkbenchCraftRecipe]
{
	val internalUpgradeStorage = mutable.Set[ItemStack]()
}
