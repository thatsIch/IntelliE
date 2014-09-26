package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 20.09.2014.
 */
private[skydiver]
class SkyDiverFunctionalityConfigAccess(config: Config)
extends SkyDiverFunctionalityConfig
{
	this.config.save()

	val minimalBreathing = this.config.getInt("Functionality", "minimalStepHeight", 0)

	val maximalBreathing: Int = this.config.getInt("Functionality", "maximalBreathing", 300)

}
