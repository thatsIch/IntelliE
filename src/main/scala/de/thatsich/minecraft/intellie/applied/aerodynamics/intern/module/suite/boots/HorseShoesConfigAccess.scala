package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots


import de.thatsich.minecraft.common.config.SimpleConfig
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.item.config.HorseShoesConfigPath


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
trait HorseShoesConfigAccess
{
	final val path = new HorseShoesConfigPath
	final val config = new SimpleConfig(this.path)

	final val initArmorLevel = this.config.getDouble("Combat", "maxArmorLevel", 0)
	final val maxArmorLevel = this.config.getDouble("Combat", "maxArmorLevel", 4)

	final val initEnergy = this.config.getDouble("Energy", "initEnergy", 0)
	final val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 4000000)
	final val initChargedMultiplier = this.config.getDouble("Energy", "initChargedMultiplier", 1)
	final val maxChargedMultiplier = this.config.getDouble("Energy", "maxChargedMultiplier", 10000)
	final val initDischargePerTick = this.config.getDouble("Energy", "initDischargePerTick", 400)
	final val minDischargePerTick = this.config.getDouble("Energy", "minDischargePerTick", 40)
}
