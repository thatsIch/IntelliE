package de.thatsich.minecraft.intellie

import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.intellie.common.{OIntelligentEnergisticsConfigurationFiles, TIntelligentEnergisticsConfig, ABaseMod, TModUnloader}
import de.thatsich.minecraft.intellie.common.logger.OIntelligentEnergisticsLog
import de.thatsich.minecraft.intellie.common.registries.ORegistries

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = "intellie",
	name = "IntelligentEnergistics",
	version = "${version}",
	dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);after:appliedenergistics2",
	modLanguage = "scala"
)
object IntelligentEnergistics
	extends ABaseMod(OIntelligentEnergisticsLog, ORegistries, OIntelligentEnergisticsConfigurationFiles)
	with TModUnloader
	with TIntelligentEnergisticsConfig
{
	this.unload("appaero", this.disableAero)
	this.unload("appagri", this.disableAgro)
	this.unload("appint", this.disableInt)
}
