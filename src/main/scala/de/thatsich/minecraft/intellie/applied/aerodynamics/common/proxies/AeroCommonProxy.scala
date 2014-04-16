package de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies

import de.thatsich.minecraft.core.ICommonProxy
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
class AeroCommonProxy extends ICommonProxy
{
	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	def postInit(event: FMLPostInitializationEvent)
	{

	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	def init(event: FMLInitializationEvent)
	{

	}

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	def preInit(event: FMLPreInitializationEvent)
	{

	}
}
