package de.thatsich.minecraft.intellie

import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.common.{BaseMod, Proxy}
import de.thatsich.minecraft.intellie.intern.unloadchilds.{ChildUnloader, ChildUnloaderConfigAccess}


/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = IntelligentEnergistics.id,
	name = IntelligentEnergistics.name,
	version = IntelligentEnergistics.version,
	dependencies = IntelligentEnergistics.dependencies,
	modLanguage = "scala"
)
object IntelligentEnergistics extends BaseMod with ChildUnloader with ChildUnloaderConfigAccess
{
	final val id           = "intellie"
	final val name         = "Intelligent Energistics"
	final val version      = "${version}"
	final val dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);after:appliedenergistics2"

	val proxy: Proxy = null

	this.unload( "appaero", this.disableAero )
	this.unload( "appagri", this.disableAgro )
	this.unload( "appint", this.disableInt )
}