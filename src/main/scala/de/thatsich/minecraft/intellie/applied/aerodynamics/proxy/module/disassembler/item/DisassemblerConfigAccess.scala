package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config.DisassemblerConfig


/**
 *
 *
 * @author thatsIch
 * @since 02.08.2014.
 */
trait DisassemblerConfigAccess
{
	val config = new DisassemblerConfig()

	// Mining
	val initMiningSpeed = this.config.getDouble("General", "initialMiningSpeed", 1)
	val maxMiningSpeed = this.config.getDouble("General", "maxMiningSpeed", 5000)
	val initMiningLevel = this.config.getDouble("General", "initialMiningLevel", 0)
	val maxMiningLevel = this.config.getDouble("General", "maxMiningLevel", 5)
	// Weapon
	val initDamageVsEntites = this.config.getDouble("Combat", "initialDamageVsEntites", 0)
	val maxDamageVsEntites = this.config.getDouble("Combat", "maxDamageVsEntities", 20)
	// Energy
	val initEnergy = this.config.getDouble("Energy", "initialEnergy", 0)
	val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 100000000)
	val initChargeMultiplier = this.config.getDouble("Energy", "initialChargeMultiplier", 1)
	val maxChargeMultiplier = this.config.getDouble("Energy", "maxChargeMultiplier", 10000)
	val initEnergyUsage = this.config.getDouble("Energy", "initEnergyPerBlockBreak", 100000)
	val minEnergyUsage = this.config.getDouble("Energy", "minEnergyPerBlockBreak", 6666)

	this.config.save()
}
