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
	private final val path = new DissemblerConfigPath
	private final val config = new DissemblerConfig(path)

	// Mining
	protected final val initMiningSpeed = this.config.getInt("General", "initialMiningSpeed", 0)
	protected final val miningSpeedPerUpgrade = this.config.getInt("General", "miningSpeedPerUpgrade", 1)
	protected final val maxMiningSpeed = this.config.getInt("General", "maxMiningSpeed", 5000)

	protected final val initMiningLevel = this.config.getInt("General", "initialMiningLevel", 0)
	protected final val miningLevelPerUpgrade = this.config.getInt("General", "miningLevelPerUpgrade", 1)
	protected final val maxMiningLevel = this.config.getInt("General", "maxMiningLevel", 5)

	// Weapon
	protected final val initDamageVsEntites = this.config.getDouble("Combat", "initialDamageVsEntites", 0)
	protected final val damagePerUpgrade = this.config.getInt("Combat", "damagePerUpgrade", 1)
	protected final val maxDamageVsEntites = this.config.getDouble("Combat", "maxDamageVsEntities", 20)

	// Energy
	protected final val initEnergy = this.config.getDouble("Energy", "initialEnergy", 0)
	protected final val energyPerUpgrade = this.config.getInt("Energy", "energyPerUpgrade", 1)
	protected final val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 100000000)

	protected final val initChargeMultiplier = this.config.getDouble("Energy", "initialChargeMultiplier", 1)
	protected final val chargePerUpgrade = this.config.getInt("Energy", "chargePerUpgrade", 5)
	protected final val maxChargeMultiplier = this.config.getDouble("Energy", "maxChargeMultiplier", 10000)

	protected final val initEnergyPerBlockBreak = this.config.getDouble("Energy", "initEnergyPerBlockBreak", 100000)
	protected final val energyUsagePerUpgrade = this.config.getInt("Energy", "energyUsagePerUpgrade", 1500)
	protected final val minEnergyPerBlockBreak = this.config.getDouble("Energy", "minEnergyPerBlockBreak", 6666)

	this.config.save()
}
