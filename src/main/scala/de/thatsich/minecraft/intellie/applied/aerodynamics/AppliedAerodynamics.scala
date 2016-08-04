package de.thatsich.minecraft.intellie.applied.aerodynamics


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}


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
object AppliedAerodynamics extends AeroAPI
{
	final val id = "appaero"
	final val name = "Applied Aerodynamics"
	final val version = "@version@"
	final val dependencies = "required-after:intellie"

	@SidedProxy(
		modId = AppliedAerodynamics.id,
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.AeroServerProxy"
	)
	var proxy: AeroCommonProxy = _

	@Mod.EventHandler
	def onPreInit(event: FMLPreInitializationEvent): Unit = this.proxy.onPreInit(event)

	@Mod.EventHandler
	def onInit(event: FMLInitializationEvent): Unit = this.proxy.onInit(event)

	@Mod.EventHandler
	def onPostInit(event: FMLPostInitializationEvent): Unit = this.proxy.onPostInit(event)
}
