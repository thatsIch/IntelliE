package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinition
import de.thatsich.minecraft.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
class HorseShoesDefinition(modid: ID, log: Log) extends BaseDefinition(
	items = Vector(new HorseShoesItem(modid, log)),
	recipes = Vector()
)