package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
private[horseshoes] class HorseShoesFunctionalityConfigAccess(config: Config)
extends HorseShoesFunctionalityConfig
{
	val minimalStepHeight = this.config.getDouble("Functionality", "minimalStepHeight", 0.5)
	val maximalStepHeight = this.config.getDouble("Functionality", "maximalStepHeight", 1)

	this.config.save()
}
