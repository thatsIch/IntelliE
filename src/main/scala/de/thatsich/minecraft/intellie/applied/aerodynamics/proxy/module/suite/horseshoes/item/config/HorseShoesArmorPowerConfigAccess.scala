package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config


import de.thatsich.minecraft.common.config.Config
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item.config.ArmorPowerConfig


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
private[horseshoes]
class HorseShoesArmorPowerConfigAccess(config: Config)
extends ArmorPowerConfig
{
	val minimalEnergy: Double = this.config.getDouble("Energy", "minimalEnergy", 0)
	val maximalEnergy: Double = this.config.getDouble("Energy", "maximalEnergy", 4000000)
	val minimalDischargePerTick: Double = this.config.getDouble("Energy", "minimalDischargePerTick", 10)
	val maximalDischargePerTick: Double = this.config.getDouble("Energy", "maximalDischargePerTick", 100)
	val minimalEnergyPerDamagePoint: Double = this.config.getDouble("Energy", "minimalEnergyPerDamagePoint", 1000)
	val maximalEnergyPerDamagePoint: Double = this.config.getDouble("Energy", "maximalEnergyPerDamagePoint", 100000)
	val minimalChargeMultiplier: Int = this.config.getInt("Energy", "minimalChargeMultiplier", 1)
	val maximalChargeMultiplier: Int = this.config.getInt("Energy", "maximalChargeMultiplier", 100)

	this.config.save()
}
