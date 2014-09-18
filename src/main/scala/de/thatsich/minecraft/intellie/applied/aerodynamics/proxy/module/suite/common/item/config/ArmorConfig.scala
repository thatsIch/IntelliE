package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item.config

/**
 * 
 *
 * @author thatsIch
 * @since 17.09.2014.
 */
private[suite] trait ArmorConfig
{
	def minimalAbsorptionRatio: Double

	def maximalAbsorptionRatio: Double

	def minimalArmorBase: Int

	def maximalArmorBase: Int

	def minimalEnergyPerDamage: Double

	def maximalEnergyPerDamage: Double
}
