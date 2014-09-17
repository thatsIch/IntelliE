package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
trait HorseShoesArmorConfig
{
	def minimalAbsorptionRatio: Double

	def maximalAbsorptionRatio: Double

	def minimalArmorBase: Int

	def maximalArmorBase: Int

	def minimalEnergyPerDamage: Double

	def maximalEnergyPerDamage: Double
}
