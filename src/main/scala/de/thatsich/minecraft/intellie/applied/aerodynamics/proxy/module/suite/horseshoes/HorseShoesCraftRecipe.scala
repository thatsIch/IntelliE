package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.recipe.{ExternalHorseShoesCraftRecipePath, InternalHorseShoesCraftRecipePath}


/**
 * 
 *
 * @author thatsIch
 * @since 11.09.2014.
 */
class HorseShoesCraftRecipe
extends BaseRecipe(
	new InternalHorseShoesCraftRecipePath,
	new ExternalHorseShoesCraftRecipePath
)