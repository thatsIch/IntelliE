package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinitions
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
class SuiteDefinitions(modid: ID, log: Log) extends BaseDefinitions(
	modules = Vector(
		new InternalHorseShoesModule(modid, log)
	)
)