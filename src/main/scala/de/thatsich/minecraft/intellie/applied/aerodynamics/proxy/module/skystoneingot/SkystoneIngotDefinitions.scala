package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.skystoneingot


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ModID


/**
 * 
 *
 * @author thatsIch
 * @since 11.09.2014.
 */
class SkystoneIngotDefinitions(modid: ModID, log: Log)
	extends BaseDefinitions(
		items = Vector(new SkystoneIngotItem(modid, log)),
		recipes = Vector(new SkystoneIngotCraftRecipe)
	)