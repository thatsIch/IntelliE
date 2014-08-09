package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler


import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.config.{DissemblerConfig, DissemblerConfigPath}


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
	protected final val maxMiningSpeed = this.config.getInt("General", "maxMiningSpeed", 5000)

	protected final val initMiningLevel = this.config.getInt("General", "initialMiningLevel", 0)
	protected final val maxMiningLevel = this.config.getInt("General", "maxMiningLevel", 5)

	// Weapon
	protected final val initDamageVsEntites = this.config.getDouble("Combat", "initialDamageVsEntites", 0)
	protected final val maxDamageVsEntites = this.config.getDouble("Combat", "maxDamageVsEntities", 20)

	// Energy
	protected final val initEnergy = this.config.getDouble("Energy", "initialEnergy", 0)
	protected final val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 1000000)

	protected final val initChargePerTick = this.config.getDouble("Energy", "initialChargePerTick", 0)
	protected final val maxChargePerTick = this.config.getDouble("Energy", "maxChargePerTick", 10000)

	protected final val initEnergyPerBlockBreak = this.config.getDouble("Energy", "initEnergyPerBlockBreak", 1000)
	protected final val minEnergyPerBlockBreak = this.config.getDouble("Energy", "minEnergyPerBlockBreak", 250)

	this.config.save()
}
