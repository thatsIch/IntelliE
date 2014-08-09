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

	protected final val miningSpeed = this.config.getInt("General", "miningSpeed", 5000)
	protected final val initEnergy = this.config.getDouble("Energy", "initialEnergy", 0)
	protected final val maxEnergy = this.config.getDouble("Energy", "maxEnergy", 1000000)
	protected final val chargePerTick = this.config.getDouble("Energy", "chargePerTick", 10000)
	protected final val energyPerBlockBreak = this.config.getDouble("Energy", "energyPerBlockBreak", 250)

	this.config.save()
}
