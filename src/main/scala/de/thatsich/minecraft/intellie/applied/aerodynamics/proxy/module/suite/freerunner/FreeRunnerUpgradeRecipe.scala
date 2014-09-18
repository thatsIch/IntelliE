package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.recipe.{ExternalFreeRunnerUpgradeRecipePath, InternalFreeRunnerUpgradeRecipePath}


/**
 * 
 *
 * @author thatsIch
 * @since 17.09.2014.
 */
class FreeRunnerUpgradeRecipe
extends BaseRecipe(
	new InternalFreeRunnerUpgradeRecipePath,
	new ExternalFreeRunnerUpgradeRecipePath
)
