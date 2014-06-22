package de.thatsich.minecraft.intellie.applied.aerodynamics

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, Optional, SidedProxy}
import de.thatsich.minecraft.core.{ABaseMod, EMods, ICommonProxy}

/**
 * d
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = EMods.AERO.id,
	name = EMods.AERO.name,
	version = EMods.AERO.version,
	dependencies = EMods.AERO.dependencies,
	modLanguage = "scala"
)
object AppliedAerodynamics
	extends ABaseMod
{
	@SidedProxy(
		modId = EMods.AERO.id,
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies.AeroCommonProxy"
	)
	var proxy: ICommonProxy = null

	@Optional.Method( modid = EMods.AERO.id )
	@Mod.EventHandler
	override def preInit( event: FMLPreInitializationEvent ): Unit = super.preInit( event )

	@Optional.Method( modid = EMods.AERO.id )
	@Mod.EventHandler
	override def init( event: FMLInitializationEvent ): Unit = super.init( event )

	@Optional.Method( modid = EMods.AERO.id )
	@Mod.EventHandler
	override def postInit( event: FMLPostInitializationEvent ): Unit = super.postInit( event )
}
