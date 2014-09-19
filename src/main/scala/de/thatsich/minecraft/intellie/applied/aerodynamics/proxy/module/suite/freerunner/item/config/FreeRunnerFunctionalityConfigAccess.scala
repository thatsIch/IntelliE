package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 18.09.2014.
 */
private[freerunner] class FreeRunnerFunctionalityConfigAccess(config: Config)
extends FreeRunnerFunctionalityConfig
{
	val minimalWalkSpeed = this.config.getDouble("Functionality", "minimalWalkSpeed", 0.1)
	val minimalRunSpeed = this.config.getDouble("Functionality", "minimalRunSpeed", 0.15)
	val maximalRunSpeed = this.config.getDouble("Functionality", "maximalRunSpeed", 0.2)
	val maximalWalkSpeed = this.config.getDouble("Functionality", "maximalWalkSpeed", 0.11)

	this.config.save()
}
