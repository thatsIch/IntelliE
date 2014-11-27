package de.thatsich.minecraft.intellie.child


/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class ChildUnloaderConfigAccess
{
	val path = new ChildUnloaderConfigPath
	val config = new ChildUnloaderConfig(path)

	val disableAero = this.config.getBoolean("ChildMod", "disableAppliedAerodynamics", defaultValue = false)
	val disableAgro = this.config.getBoolean("ChildMod", "disableAppliedAgricultures", defaultValue = false)
	val disableInt = this.config.getBoolean("ChildMod", "disableAppliedIntelligences", defaultValue = false)

	val disableAeroNEI = this.config.getBoolean("ChildModIntegration", "disableAppliedAerodynamicsNEI", defaultValue = false)

	val disableNEI = this.config.getBoolean("Integration", "disableNEI", defaultValue = false)

	this.config.save()
}
