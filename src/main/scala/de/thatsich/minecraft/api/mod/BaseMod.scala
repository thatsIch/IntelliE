package de.thatsich.minecraft.api.mod

import com.google.common.base.Stopwatch
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.module.ModuleRegistry
import de.thatsich.minecraft.api.mod.network.BasePacketPipeline

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
abstract class BaseMod( implicit protected val log: Log,
                        implicit protected val modules: Modules )
	extends Proxy
{
	def proxy: Proxy

	protected val registries: ModuleRegistry     = new ModuleRegistry( modules, log )
	protected val pipeline  : BasePacketPipeline = new BasePacketPipeline( log )

	private val stopwatch: Stopwatch = Stopwatch.createUnstarted

	def preInit( event: FMLPreInitializationEvent ): Unit =
	{
		this.log.info( "PreInit Begin" )

		this.stopwatch.start

		this.registries.preInit( event )
		this.pipeline.preInit( event )
		this.proxy.preInit( event )

		this.stopwatch.stop

		this.log.info( s"PreInit End ($stopwatch)" )
	}

	def init( event: FMLInitializationEvent ): Unit =
	{
		this.log.info( "Init Begin" )

		this.stopwatch.reset.start

		this.registries.init( event )
		this.pipeline.init( event )
		this.proxy.init( event )

		this.stopwatch.stop

		this.log.info( s"Init End ($stopwatch)" )
	}

	def postInit( event: FMLPostInitializationEvent ): Unit =
	{
		this.log.info( "PostInit Begin" )

		this.stopwatch.reset.start

		this.registries.postInit( event )
		this.pipeline.postInit( event )
		this.proxy.postInit( event )

		this.stopwatch.stop

		this.log.info( s"PostInit End ($stopwatch)" )
	}
}
