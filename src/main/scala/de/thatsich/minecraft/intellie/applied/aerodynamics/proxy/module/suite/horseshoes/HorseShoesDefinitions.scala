package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ModID


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
class HorseShoesDefinitions(modid: ModID, log: Log) extends BaseDefinitions(
	items = Vector(new HorseShoesItem(modid, log)),
	recipes = Vector(new HorseShoesCraftRecipe, new HorseShoesUpgradeRecipe)
)