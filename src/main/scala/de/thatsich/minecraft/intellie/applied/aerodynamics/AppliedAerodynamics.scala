package de.thatsich.minecraft.intellie.applied.aerodynamics

import cpw.mods.fml.common.{SidedProxy, Optional, Mod}
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.core.{ICommonProxy, ABaseMod}

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
object AppliedAerodynamics
	extends ABaseMod
{
	@SidedProxy(
		modId = "appaero",
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroCommonProxy"
	)
	var proxy: ICommonProxy = null

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler
	override def preInit(event: FMLPreInitializationEvent)
	{
		super.preInit(event)
	}

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler
	override def init(event: FMLInitializationEvent)
	{
		super.init(event)
		//		FMLCommonHandler.instance.bus.register(new KeyHandler)
	}

	@Optional.Method(modid = "appaero")
	@Mod.EventHandler
	override def postInit(event: FMLPostInitializationEvent)
	{
		super.postInit(event)
	}
}
