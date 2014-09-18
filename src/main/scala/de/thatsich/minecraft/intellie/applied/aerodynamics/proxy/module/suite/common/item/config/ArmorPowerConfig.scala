package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item.config

/**
 * 
 *
 * @author thatsIch
 * @since 17.09.2014.
 */
private[suite] trait ArmorPowerConfig
{
	def minimalEnergy: Double

	def maximalEnergy: Double

	def minimalChargeMultiplier: Int

	def maximalChargeMultiplier: Int

	def minimalDischargePerTick: Double

	def maximalDischargePerTick: Double

	def minimalEnergyPerDamagePoint: Double

	def maximalEnergyPerDamagePoint: Double
}
