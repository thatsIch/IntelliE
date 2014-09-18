package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.recipe.{InternalChestNutCraftRecipePath, ExternalChestNutCraftRecipePath}


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private[chestnut] class ChestNutCraftRecipe
extends BaseRecipe(
	new InternalChestNutCraftRecipePath,
	new ExternalChestNutCraftRecipePath
)