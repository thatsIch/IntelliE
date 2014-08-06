package de.thatsich.minecraft.intellie.applied.aerodynamics

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Optional, Mod, SidedProxy}
import de.thatsich.minecraft.common.{BaseMod, Proxy}

/**
 * d
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = AppliedAerodynamics.id,
	name = AppliedAerodynamics.name,
	version = AppliedAerodynamics.version,
	dependencies = AppliedAerodynamics.dependencies,
	modLanguage = "scala"
)
object AppliedAerodynamics extends BaseMod
{
	final val id           = "appaero"
	final val name         = "Applied Aerodynamics"
	final val version      = "${version}"
	final val dependencies = "required-after:intellie"

	@SidedProxy(
		modId = AppliedAerodynamics.id,
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy.AeroServerProxy"
	)
	var proxy: Proxy = null

	@Optional.Method( modid = AppliedAerodynamics.id )
	@Mod.EventHandler
	override def preInit( event: FMLPreInitializationEvent ): Unit = super.preInit( event )

	@Optional.Method( modid = AppliedAerodynamics.id )
	@Mod.EventHandler
	override def init( event: FMLInitializationEvent ): Unit = super.init( event )

	@Optional.Method( modid = AppliedAerodynamics.id )
	@Mod.EventHandler
	override def postInit( event: FMLPostInitializationEvent ): Unit = super.postInit( event )
}
