package de.thatsich.minecraft.intellie.applied.aerodynamics

import cpw.mods.fml.common.{SidedProxy, Optional, Mod}
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.OAppliedAerodynamicsLog
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.intellie.common.{ABaseMod, ICommonProxy}

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
object AppliedAerodynamics extends ABaseMod(OAppliedAerodynamicsLog)
{
	@SidedProxy(
		modId = "appaero",
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroCommonProxy"
	)
	var s_proxy: ICommonProxy = null

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
