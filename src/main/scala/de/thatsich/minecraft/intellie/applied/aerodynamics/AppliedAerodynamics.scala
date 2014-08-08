package de.thatsich.minecraft.intellie.applied.aerodynamics


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, Optional, SidedProxy}
import de.thatsich.minecraft.common.proxy.EventProxy


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
object AppliedAerodynamics
{
	final val id = "appaero"
	final val name = "Applied Aerodynamics"
	final val version = "${version}"
	final val dependencies = "required-after:intellie"

	@SidedProxy(
		modId = AppliedAerodynamics.id,
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy.AeroServerProxy"
	)
	var proxy: EventProxy = null

	@Optional.Method(modid = AppliedAerodynamics.id)
	@Mod.EventHandler
	def preInit(event: FMLPreInitializationEvent): Unit = this.proxy.preInit(event)

	@Optional.Method(modid = AppliedAerodynamics.id)
	@Mod.EventHandler
	def init(event: FMLInitializationEvent): Unit = this.proxy.init(event)

	@Optional.Method(modid = AppliedAerodynamics.id)
	@Mod.EventHandler
	def postInit(event: FMLPostInitializationEvent): Unit = this.proxy.postInit(event)
}
