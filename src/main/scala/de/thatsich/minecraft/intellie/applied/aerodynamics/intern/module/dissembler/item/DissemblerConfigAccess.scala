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
	// Mining
	protected final val initMiningSpeed = this.config.getDouble("General", "initialMiningSpeed", 1)
	protected final val maxMiningSpeed = this.config.getDouble("General", "maxMiningSpeed", 5000)
	protected final val initMiningLevel = this.config.getDouble("General", "initialMiningLevel", 0)
	protected final val maxMiningLevel = this.config.getDouble("General", "maxMiningLevel", 5)
	// Weapon
	protected final val initDamageVsEntites = this.config.getDouble("Combat", "initialDamageVsEntites", 0)
	protected final val maxDamageVsEntites = this.config.getDouble("Combat", "maxDamageVsEntities", 20)
	// Energy
	protected final val initEnergy = this.config.getDouble("Energy", "initialEnergy", 0)
	protected final val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 100000000)
	protected final val initChargeMultiplier = this.config.getDouble("Energy", "initialChargeMultiplier", 1)
	protected final val maxChargeMultiplier = this.config.getDouble("Energy", "maxChargeMultiplier", 10000)
	protected final val initEnergyUsage = this.config.getDouble("Energy", "initEnergyPerBlockBreak", 100000)
	protected final val minEnergyUsage = this.config.getDouble("Energy", "minEnergyPerBlockBreak", 6666)
	private final val path = new DissemblerConfigPath
	private final val config = new DissemblerConfig(path)

	this.config.save()
}
