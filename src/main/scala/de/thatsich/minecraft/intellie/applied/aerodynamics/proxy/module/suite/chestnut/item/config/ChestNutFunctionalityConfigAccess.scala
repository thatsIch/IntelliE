package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private [chestnut]
class ChestNutFunctionalityConfigAccess(config: Config)
extends ChestNutFunctionalityConfig
{
	val minimalFlySpeed = this.config.getFloat("Functionality", "minimalFlySpeed", 0.05F)
	val maximalFlySpeed = this.config.getFloat("Functionality", "maximalFlySpeed", 0.1F)

	this.config.save()


}
