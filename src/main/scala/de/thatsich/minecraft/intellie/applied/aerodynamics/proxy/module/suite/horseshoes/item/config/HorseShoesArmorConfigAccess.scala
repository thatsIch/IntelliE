package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
class HorseShoesArmorConfigAccess(config: Config) extends HorseShoesArmorConfig
{
	val minimalAbsorptionRatio = this.config.getDouble("Combat", "minimalAbsorptionRatio", 0)
	val maximalAbsorptionRatio = this.config.getDouble("Combat", "maximalAbsorptionRatio", 0.44)
	val minimalArmorBase = this.config.getDouble("Combat", "minimalArmorBase", 0)
	val maximalArmorBase = this.config.getDouble("Combat", "maximalArmorBase", 20)
	val minimalEnergyPerDamage = this.config.getDouble("Combat", "minimalEnergyPerDamage", 100)
	val maximalEnergyPerDamage = this.config.getDouble("Combat", "maximalEnergyPerDamage", 10000)

	this.config.save()
}
