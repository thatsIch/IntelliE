package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.config


import de.thatsich.minecraft.common.config.Config
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item.config.ArmorConfig


/**
 * 
 *
 * @author thatsIch
 * @since 17.09.2014.
 */
class FreeRunnerArmorConfigAccess(config: Config)
extends ArmorConfig
{
	val minimalAbsorptionRatio = this.config.getDouble("Combat", "minimalAbsorptionRatio", 0)
	val maximalAbsorptionRatio = this.config.getDouble("Combat", "maximalAbsorptionRatio", 0.44)
	val minimalArmorBase = this.config.getInt("Combat", "minimalArmorBase", 0)
	val maximalArmorBase = this.config.getInt("Combat", "maximalArmorBase", 17)
	val minimalEnergyPerDamage = this.config.getDouble("Combat", "minimalEnergyPerDamage", 100)
	val maximalEnergyPerDamage = this.config.getDouble("Combat", "maximalEnergyPerDamage", 10000)

	this.config.save()
}