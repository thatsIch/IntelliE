package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.recipe.{ExternalSkyDiverUpgradeRecipePath, InternalSkyDiverUpgradeRecipePath}


/**
 * 
 *
 * @author thatsIch
 * @since 20.09.2014.
 */
private[skydiver]
class SkyDiverUpgradeRecipe
extends BaseRecipe(
	new InternalSkyDiverUpgradeRecipePath,
	new ExternalSkyDiverUpgradeRecipePath
)
