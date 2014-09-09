package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.horseshoes


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinitions
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
class HorseShoesDefinitions(modid: ID, log: Log) extends BaseDefinitions(
	items = Vector(new HorseShoesItem(modid, log)),
	recipes = Vector()
)