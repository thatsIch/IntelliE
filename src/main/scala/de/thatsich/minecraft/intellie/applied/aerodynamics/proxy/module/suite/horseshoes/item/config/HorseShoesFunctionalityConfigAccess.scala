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
	val minimalExtraStepHeight = this.config.getDouble("Functionality", "minimalExtraStepHeight", 0)
	val maximalExtraStepHeight = this.config.getDouble("Functionality", "maximalExtraStepHeight", 0.5)

	this.config.save()
}
