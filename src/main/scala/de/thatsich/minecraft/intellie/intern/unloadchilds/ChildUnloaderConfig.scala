package de.thatsich.minecraft.intellie.intern.unloadchilds

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
trait ChildUnloaderConfig
{
	val config = new IEChildConfig( ConfigPath )

	protected val disableAero = this.config.getBoolean( "ChildMods", "disableAppliedAerodynamics", defaultValue = false )
	protected val disableAgro = this.config.getBoolean( "ChildMods", "disableAppliedAgricultures", defaultValue = false )
	protected val disableInt  = this.config.getBoolean( "ChildMods", "disableAppliedIntelligences", defaultValue = false )

	this.config.save( )
}
