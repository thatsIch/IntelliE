package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.recipe.{ExternalSkyDiverCraftRecipePath, InternalSkyDiverCraftRecipePath}


/**
 * 
 *
 * @author thatsIch
 * @since 20.09.2014.
 */
private[skydiver]
class SkyDiverCraftRecipe
extends BaseRecipe(
	new InternalSkyDiverCraftRecipePath,
	new ExternalSkyDiverCraftRecipePath
)