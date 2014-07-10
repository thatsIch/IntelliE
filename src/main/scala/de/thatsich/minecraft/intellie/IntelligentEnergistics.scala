package de.thatsich.minecraft.intellie

import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.api.mod.BaseMod
import de.thatsich.minecraft.core.{ICommonProxy, TModUnloader}
import de.thatsich.minecraft.intellie.api.IEModInfo
import de.thatsich.minecraft.intellie.intern.TIntelliConfig


/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = IEModInfo.id,
	name = IEModInfo.name,
	version = IEModInfo.version,
	dependencies = IEModInfo.dependencies,
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
