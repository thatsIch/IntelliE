package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.recipe.{ExternalChestNutUpgradeRecipePath, InternalChestNutUpgradeRecipePath}


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private[chestnut] class ChestNutUpgradeRecipe
extends BaseRecipe(
	new InternalChestNutUpgradeRecipePath,
	new ExternalChestNutUpgradeRecipePath
)
