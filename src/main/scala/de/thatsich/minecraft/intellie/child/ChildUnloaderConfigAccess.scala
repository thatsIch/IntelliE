package de.thatsich.minecraft.intellie.child


/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
trait ChildUnloaderConfigAccess
{
	val path = new ChildUnloaderConfigPath
	val config = new ChildUnloaderConfig(path)

	val disableAero = this.config.getBoolean("ChildMods", "disableAppliedAerodynamics", defaultValue = false)
	val disableAgro = this.config.getBoolean("ChildMods", "disableAppliedAgricultures", defaultValue = false)
	val disableInt = this.config.getBoolean("ChildMods", "disableAppliedIntelligences", defaultValue = false)

	val disableAeroNEI = this.config.getBoolean("ChildModIntegration", "disableAppliedAerodynamicsNEI", defaultValue = false)

	val disableNEI = this.config.getBoolean("Integration", "disableNEI", defaultValue = false)

	this.config.save()
}
