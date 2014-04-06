package de.thatsich.minecraft.intellie

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.intellie.common.TIntelligentEnergisticsConfig
import de.thatsich.minecraft.intellie.common.{ABaseMod, TModUnloader}
import de.thatsich.minecraft.intellie.common.logger.OIntelligentEnergisticsLog

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
	extends ABaseMod(OIntelligentEnergisticsLog)
	with TModUnloader
	with TIntelligentEnergisticsConfig
{
	this.unload("appaero", this.disableAero)
	this.unload("appagri", this.disableAgro)
	this.unload("appint", this.disableInt)

	@Mod.EventHandler def preInit(event: FMLPreInitializationEvent)
	{
		this.log.info("PreInit Start")
		this.log.info("PreInit End")
	}

	@Mod.EventHandler def init(event: FMLInitializationEvent)
	{
		this.log.info("Init Start")
		this.log.info("Init End")
	}

	@Mod.EventHandler def postInit(event: FMLPostInitializationEvent)
	{
		this.log.info("PostInit Start")
		this.log.info("PostInit End")
	}
}
