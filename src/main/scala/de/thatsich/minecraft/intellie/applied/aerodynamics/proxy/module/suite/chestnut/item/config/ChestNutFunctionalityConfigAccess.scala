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
	val minimalFlySpeed = this.config.getDouble("Functionality", "minimalFlySpeed", 0.05)
	val maximalFlySpeed = this.config.getDouble("Functionality", "maximalFlySpeed", 0.19)
	val ticksToRegisterDoubleJump = this.config.getInt("Functionality", "ticksToRegisterDoubleJump", 7)

	this.config.save()
}
