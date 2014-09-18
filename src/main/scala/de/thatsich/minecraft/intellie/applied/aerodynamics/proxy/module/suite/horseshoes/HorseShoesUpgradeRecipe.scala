package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.recipe.{ExternalHorseShoesUpgradeRecipePath, InternalHorseShoesUpgradeRecipePath}


/**
 * 
 *
 * @author thatsIch
 * @since 11.09.2014.
 */
private[horseshoes] class HorseShoesUpgradeRecipe
extends BaseRecipe(
	new InternalHorseShoesUpgradeRecipePath,
	new ExternalHorseShoesUpgradeRecipePath
)
