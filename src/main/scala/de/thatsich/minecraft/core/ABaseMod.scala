package de.thatsich.minecraft.core

import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLInitializationEvent, FMLPostInitializationEvent}
import de.thatsich.minecraft.core.config.IConfig
import de.thatsich.minecraft.core.log.ILog
import de.thatsich.minecraft.core.module.IModule
import de.thatsich.minecraft.core.network.PacketPipeline

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class ABaseMod( implicit protected val log: ILog,
                         implicit protected val modules: List[ IModule ],
                         implicit protected val registries: ModuleRegistry,
                         implicit protected val pipeline: PacketPipeline,
                         implicit protected val configs: List[ IConfig ] )
	extends IEventProxy
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
