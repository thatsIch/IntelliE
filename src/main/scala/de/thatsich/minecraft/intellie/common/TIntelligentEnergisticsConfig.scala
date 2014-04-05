package de.thatsich.minecraft.intellie.common

import com.google.common.base.Joiner
import java.io.File
import de.thatsich.minecraft.common.Config

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
trait TIntelligentEnergisticsConfig
{
	private val modName = this.getClass.getSimpleName
	private val configPath = Joiner.on(File.separatorChar).join("config", "AppliedEnergistics2", "IntelliE", this.modName + ".cfg")
	private val config = new Config(this.configPath)

	private val disableAero = this.config.getBoolean("ChildMods", "disableAppliedAerodynamics", defaultValue = false)
	private val disableAgro = this.config.getBoolean("ChildMods", "disableAppliedAgricultures", defaultValue = false)
	private val disableInt = this.config.getBoolean("ChildMods", "disableAppliedIntelligences", defaultValue = false)

	this.unload("appaero", this.disableAero)
	this.unload("appagri", this.disableAgro)
	this.unload("appint", this.disableInt)

	this.config.save()
}
