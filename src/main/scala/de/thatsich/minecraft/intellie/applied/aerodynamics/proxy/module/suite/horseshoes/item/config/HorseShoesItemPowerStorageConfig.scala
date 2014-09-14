package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
trait HorseShoesItemPowerStorageConfig
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
