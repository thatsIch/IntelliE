package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler.config.{DissemblerConfig, DissemblerConfigPath}

/**
 *
 *
 * @author thatsIch
 * @since 02.08.2014.
 */
trait DissemblerConfigAccess
{
	private val path   = new DissemblerConfigPath
	private val config = new DissemblerConfig( path )

	protected final val miningSpeed         = this.config.getInt( "General", "miningSpeed", 5000 )
	protected final val maxEnergy           = this.config.getDouble( "Energy", "maxEnergy", 1000000 )
	protected final val chargePerTick       = this.config.getDouble( "Energy", "chargePerTick", 10000 )
	protected final val energyPerBlockBreak = this.config.getDouble( "Energy", "energyPerBlockBreak", 250 )

	this.config.save( )
}
