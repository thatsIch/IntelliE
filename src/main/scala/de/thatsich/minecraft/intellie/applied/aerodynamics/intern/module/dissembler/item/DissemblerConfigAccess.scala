package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item.config.{DissemblerConfig, DissemblerConfigPath}


/**
 *
 *
 * @author thatsIch
 * @since 02.08.2014.
 */
trait DissemblerConfigAccess
{
	final val path = new DissemblerConfigPath
	final val config = new DissemblerConfig(path)

	// Mining
	final val initMiningSpeed = this.config.getDouble("General", "initialMiningSpeed", 1)
	final val maxMiningSpeed = this.config.getDouble("General", "maxMiningSpeed", 5000)
	final val initMiningLevel = this.config.getDouble("General", "initialMiningLevel", 0)
	final val maxMiningLevel = this.config.getDouble("General", "maxMiningLevel", 5)
	// Weapon
	final val initDamageVsEntites = this.config.getDouble("Combat", "initialDamageVsEntites", 0)
	final val maxDamageVsEntites = this.config.getDouble("Combat", "maxDamageVsEntities", 20)
	// Energy
	final val initEnergy = this.config.getDouble("Energy", "initialEnergy", 0)
	final val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 100000000)
	final val initChargeMultiplier = this.config.getDouble("Energy", "initialChargeMultiplier", 1)
	final val maxChargeMultiplier = this.config.getDouble("Energy", "maxChargeMultiplier", 10000)
	final val initEnergyUsage = this.config.getDouble("Energy", "initEnergyPerBlockBreak", 100000)
	final val minEnergyUsage = this.config.getDouble("Energy", "minEnergyPerBlockBreak", 6666)

	this.config.save()
}
