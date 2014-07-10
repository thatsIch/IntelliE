package de.thatsich.minecraft.intellie

import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.api.mod.BaseMod
import de.thatsich.minecraft.api.mod.proxy.Proxy
import de.thatsich.minecraft.intellie.api.IEModInfo
import de.thatsich.minecraft.intellie.intern._


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
object IntelligentEnergistics extends BaseMod( IELog, IEModules, IEModuleRegistry, IEPackatPipeline, IEConfigs )
                                      with ModUnloader
                                      with TIntelliConfig
{
	this.unload( "appaero", this.disableAero )
	this.unload( "appagri", this.disableAgro )
	this.unload( "appint", this.disableInt )

	val proxy: Proxy = null
}
