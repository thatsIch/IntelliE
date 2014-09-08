package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.HorseShoesModule


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
class SuiteModule(modid: ID, log: Log) extends BaseModule(
	modules = Vector(
		new HorseShoesModule(modid, log)
	)
)