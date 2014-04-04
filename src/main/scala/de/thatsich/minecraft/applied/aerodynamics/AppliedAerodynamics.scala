package de.thatsich.minecraft.applied.aerodynamics

import cpw.mods.fml.common.{Optional, Mod}
import de.thatsich.minecraft.applied.aerodynamics.common.TAALog
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = "appaero",
	name = "AppliedAerodynamics",
	version = "${version}",
	dependencies = "required-after:intellie",
	modLanguage = "scala"
)
object AppliedAerodynamics extends TAALog
{
	@Optional.Method(modid = "appaero")
	@Mod.EventHandler def preInit(event: FMLPreInitializationEvent)
	{
		this.log.info("PreInit Start")

		this.log.info("PreInit End")
	}

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler def init(event: FMLInitializationEvent)
	{
		this.log.info("Init Start")

		this.log.info("Init End")
	}

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler def postInit(event: FMLPostInitializationEvent)
	{
		this.log.info("PostInit Start")

		this.log.info("PostInit End")
	}
}
