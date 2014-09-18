package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ModID


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
class FreeRunnerDefinitions(modid: ModID, log: Log)
extends BaseDefinitions(
	items = Vector(new FreeRunnerItem(modid, log)),
	recipes = Vector(new FreeRunnerCraftRecipe, new FreeRunnerUpgradeRecipe)
)