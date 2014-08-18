package de.thatsich.minecraft.intellie.applied.aerodynamics


import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent, FMLServerStartingEvent}
import cpw.mods.fml.common.{Mod, Optional, SidedProxy}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy.AeroCommonProxy


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
	var proxy: AeroCommonProxy = null

	@Optional.Method(modid = AppliedAerodynamics.id)
	@Mod.EventHandler
	def onPreInit(event: FMLPreInitializationEvent): Unit = this.proxy.onPreInit(event)

	@Optional.Method(modid = AppliedAerodynamics.id)
	@Mod.EventHandler
	def onInit(event: FMLInitializationEvent): Unit = this.proxy.onInit(event)

	@Optional.Method(modid = AppliedAerodynamics.id)
	@Mod.EventHandler
	def onPostInit(event: FMLPostInitializationEvent): Unit = this.proxy.onPostInit(event)

	@Optional.Method(modid = AppliedAerodynamics.id)
	@Mod.EventHandler
	def onServerStarting(event: FMLServerStartingEvent): Unit = this.proxy.onServerStarting(event)
}
