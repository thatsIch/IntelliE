package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.config


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private[chestnut]
trait ChestNutFunctionalityConfig
{
	def minimalFlySpeed: Double

	def maximalFlySpeed: Double

	def ticksToRegisterDoubleJump: Int
}
