package de.thatsich.minecraft.intellie.intern.unloadchilds

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
trait ChildUnloaderConfig
{
	protected val disableAero = this.config.getBoolean( "ChildMods", "disableAppliedAerodynamics", defaultValue = false )
	protected val disableAgro = this.config.getBoolean( "ChildMods", "disableAppliedAgricultures", defaultValue = false )
	protected val disableInt  = this.config.getBoolean( "ChildMods", "disableAppliedIntelligences", defaultValue = false )
	private val config = new IEChildConfig( ConfigPath )

	this.config.save( )
}
