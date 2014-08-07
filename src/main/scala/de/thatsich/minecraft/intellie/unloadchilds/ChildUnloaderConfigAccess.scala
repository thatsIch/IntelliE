package de.thatsich.minecraft.intellie.unloadchilds

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
trait ChildUnloaderConfigAccess
{
	val path   = new ChildUnloaderConfigPath
	val config = new ChildUnloaderConfig( path )

	protected val disableAero = this.config.getBoolean( "ChildMods", "disableAppliedAerodynamics", defaultValue = false )
	protected val disableAgro = this.config.getBoolean( "ChildMods", "disableAppliedAgricultures", defaultValue = false )
	protected val disableInt  = this.config.getBoolean( "ChildMods", "disableAppliedIntelligences", defaultValue = false )

	this.config.save( )
}
