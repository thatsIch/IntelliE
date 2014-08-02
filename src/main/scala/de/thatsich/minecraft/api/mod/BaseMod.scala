package de.thatsich.minecraft.api.mod

import appeng.api.AEApi
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.api.mod.Proxy
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
//		AEApi.instance().registries().recipes().addNewSubItemResolver(new )
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
