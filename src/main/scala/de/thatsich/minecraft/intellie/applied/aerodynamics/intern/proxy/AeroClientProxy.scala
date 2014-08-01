package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.api.mod.proxy.BaseClientProxy

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
final class AeroClientProxy extends BaseClientProxy
{
	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	override def preInit( event: FMLPreInitializationEvent ): Unit =
	{
		this.initRenderers( )
		this.initSounds( )
	}

	private def initSounds( ): Unit =
	{

	}

	private def initRenderers( ): Unit =
	{

	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	def init( event: FMLInitializationEvent ): Unit =
	{

	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	def postInit( event: FMLPostInitializationEvent ): Unit =
	{

	}
}
