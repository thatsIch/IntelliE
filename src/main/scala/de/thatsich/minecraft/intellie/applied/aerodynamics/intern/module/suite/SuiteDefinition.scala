package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinition
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
class SuiteDefinition(modid: ID, log: Log) extends BaseDefinition(
	modules = Vector(
		new HorseShoesModule(modid, log)
	)
)