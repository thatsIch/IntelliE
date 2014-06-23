package de.thatsich.minecraft.intellie

import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.core.{BaseMod, EMods, ICommonProxy, TModUnloader}
import de.thatsich.minecraft.intellie.common.TIntelliConfig


/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = EMods.IE.id,
	name = EMods.IE.name,
	version = EMods.IE.version,
	dependencies = EMods.IE.dependencies,
	modLanguage = "scala"
)
object IntelligentEnergistics
	extends BaseMod
	        with TModUnloader
	        with TIntelliConfig
{
	this.unload( "appaero", this.disableAero )
	this.unload( "appagri", this.disableAgro )
	this.unload( "appint", this.disableInt )

	val proxy: ICommonProxy = null
}
