package de.thatsich.minecraft.api.mod

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.module.{Module, ModuleRegistry}
import de.thatsich.minecraft.api.mod.network.PacketPipeline
import de.thatsich.minecraft.core.ICommonProxy

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class BaseMod( implicit protected val log: Log,
                        implicit protected val modules: List[ Module ],
                        implicit protected val registries: ModuleRegistry,
                        implicit protected val pipeline: PacketPipeline,
                        implicit protected val configs: List[ Config ] )
	extends InitEventHandler
{
	def proxy: ICommonProxy

	def preInit( event: FMLPreInitializationEvent ): Unit =
	{
		this.log.info( "PreInit Begin" )
		this.registries.preInit( event )
		this.pipeline.preInit( event )
		this.proxy.preInit( event )
		this.log.info( "PreInit End" )
	}

	def init( event: FMLInitializationEvent ): Unit =
	{
		this.log.info( "Init Begin" )
		this.registries.init( event )
		this.pipeline.init( event )
		this.proxy.init( event )
		this.log.info( "Init End" )
	}

	def postInit( event: FMLPostInitializationEvent ): Unit =
	{
		this.log.info( "PostInit Begin" )
		this.registries.postInit( event )
		this.pipeline.postInit( event )
		this.proxy.postInit( event )
		this.log.info( "PostInit End" )
	}
}
