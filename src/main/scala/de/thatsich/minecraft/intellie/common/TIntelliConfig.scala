package de.thatsich.minecraft.intellie.common

import de.thatsich.minecraft.core.config.Config
import java.io.File

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
trait TIntelliConfig
{
	private val modName    = this.getClass.getSimpleName
	private val paths      = List( "config", "AppliedEnergistics2", "IntelliE", this.modName + ".cfg" )
	private val configPath = paths mkString File.separator
	println( "PATH " + configPath )
	private val config = new Config( this.configPath )

	protected val disableAero = this.config.getBoolean( "ChildMods", "disableAppliedAerodynamics", defaultValue = false )
	protected val disableAgro = this.config.getBoolean( "ChildMods", "disableAppliedAgricultures", defaultValue = false )
	protected val disableInt  = this.config.getBoolean( "ChildMods", "disableAppliedIntelligences", defaultValue = false )

	this.config.save( )
}
