package de.thatsich.minecraft.intellie.applied.aerodynamics

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent, FMLPostInitializationEvent}
import cpw.mods.fml.common.{SidedProxy, Optional, Mod}
import de.thatsich.minecraft.core.{OModIDs, ICommonProxy, ABaseMod}

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = OModIDs.AERO,
	name = "AppliedAerodynamics",
	version = "${version}",
	dependencies = "required-after:intellie",
	modLanguage = "scala"
)
object AppliedAerodynamics
	extends ABaseMod
{
	@SidedProxy(
		modId = OModIDs.AERO,
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroCommonProxy"
	)
	var proxy: ICommonProxy = null

	@Optional.Method( modid = OModIDs.AERO )
	@Mod.EventHandler
	override def preInit( event: FMLPreInitializationEvent ): Unit = super.preInit( event )

	@Optional.Method( modid = OModIDs.AERO )
	@Mod.EventHandler
	override def init( event: FMLInitializationEvent ): Unit = super.init( event )

	@Optional.Method( modid = OModIDs.AERO )
	@Mod.EventHandler
	override def postInit( event: FMLPostInitializationEvent ): Unit = super.postInit( event )
}
