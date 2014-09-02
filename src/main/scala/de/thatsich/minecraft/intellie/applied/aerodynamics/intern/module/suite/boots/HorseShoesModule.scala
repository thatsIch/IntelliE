package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.id.ID


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
class HorseShoesModule(modid: ID, log: Log) extends BaseModule(
	items = Vector(new HorseShoesItem(modid, log)),
	recipes = Vector()
)