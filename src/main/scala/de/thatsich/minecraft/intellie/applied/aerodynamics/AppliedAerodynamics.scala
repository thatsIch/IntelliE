package de.thatsich.minecraft.intellie.applied.aerodynamics

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, Optional, SidedProxy}
import de.thatsich.minecraft.api.mod.BaseMod
import de.thatsich.minecraft.api.mod.proxy.Proxy
import de.thatsich.minecraft.intellie.applied.aerodynamics.api.AeroModInfo
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern._

/**
 * d
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
@Mod(
	modid = AeroModInfo.id,
	name = AeroModInfo.name,
	version = AeroModInfo.version,
	dependencies = AeroModInfo.dependencies,
	modLanguage = "scala"
)
object AppliedAerodynamics extends BaseMod( AeroLog, AeroModules, AeroModuleRegistry, AeroPacketPipeline, AeroConfigs )
{
	@SidedProxy(
		modId = AeroModInfo.id,
		clientSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy.AeroClientProxy",
		serverSide = "de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy.AeroServerProxy"
	)
	var proxy: Proxy = null

	@Optional.Method( modid = AeroModInfo.id )
	@Mod.EventHandler
	override def preInit( event: FMLPreInitializationEvent ): Unit = super.preInit( event )

	@Optional.Method( modid = AeroModInfo.id )
	@Mod.EventHandler
	override def init( event: FMLInitializationEvent ): Unit = super.init( event )

	@Optional.Method( modid = AeroModInfo.id )
	@Mod.EventHandler
	override def postInit( event: FMLPostInitializationEvent ): Unit = super.postInit( event )
}
