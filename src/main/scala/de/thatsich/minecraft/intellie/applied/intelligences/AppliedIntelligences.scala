package de.thatsich.minecraft.intellie.applied.intelligences

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}


/**
  *
  *
  * @author thatsIch
  * @since 05.04.2014.
  */
@Mod(
	modid = "appint",
	name = "AppliedIntelligences",
	version = "${version}",
	dependencies = "required-after:intellie",
	modLanguage = "scala"
)
object AppliedIntelligences extends IntelligencesAPI {
	final val id = "appint"
	final val name = "Applied Intelligences"
	final val version = "@version@"
	final val dependencies = "required-after:intellie"

	@SidedProxy(
		modId = AppliedIntelligences.id,
		clientSide = "de.thatsich.minecraft.intellie.applied.intelligences.proxy.IntelligencesClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.intelligences.proxy.IntelligencesServerProxy"
	)
	var proxy: IntelligencesCommonProxy = _

	@Mod.EventHandler
	def onPreInit(event: FMLPreInitializationEvent): Unit = this.proxy.onPreInit(event)

	@Mod.EventHandler
	def onInit(event: FMLInitializationEvent): Unit = this.proxy.onInit(event)

	@Mod.EventHandler
	def onPostInit(event: FMLPostInitializationEvent): Unit = this.proxy.onPostInit(event)
}
