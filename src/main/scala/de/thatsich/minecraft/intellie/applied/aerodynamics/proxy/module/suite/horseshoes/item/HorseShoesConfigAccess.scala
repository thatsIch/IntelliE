package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item


import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config.HorseShoesConfig


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
trait HorseShoesConfigAccess
{
	final val config = new HorseShoesConfig

	final val initStepHeight = this.config.getDouble("Functionality", "initStepHeight", 0.5)
	final val maxStepHeight = this.config.getDouble("Functionality", "maxStepHeight", 1)

	final val initAbsorptionRatio = this.config.getDouble("Combat", "initAbsorptionRatio", 0)
	final val maxAbsorptionRatio = this.config.getDouble("Combat", "maxAbsorptionRatio", 0.44)
	final val initArmorBase = this.config.getDouble("Combat", "initArmorBase", 0)
	final val maxArmorBase = this.config.getDouble("Combat", "maxArmorBase", 20)

	final val initEnergy = this.config.getDouble("Energy", "initEnergy", 0)
	final val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 4000000)
	final val initEnergyPerDamagePoint = this.config.getDouble("Energy", "initEnergyPerDamagePoint", 100000)
	final val minEnergyPerDamagePoint = this.config.getDouble("Energy", "minEnergyPerDamagePoint", 1000)
	final val initDischargePerTick = this.config.getDouble("Energy", "initDischargePerTick", 100)
	final val minDischargePerTick = this.config.getDouble("Energy", "minDischargePerTick", 10)
	final val initChargeMultiplier = this.config.getDouble("Energy", "initChargeMultiplier", 1)
	final val maxChargeMultiplier = this.config.getDouble("Energy", "maxChargeMultiplier", 100)

	this.config.save()
}
