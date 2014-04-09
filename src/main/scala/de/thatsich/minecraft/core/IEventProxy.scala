package de.thatsich.minecraft.core

import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLInitializationEvent, FMLPostInitializationEvent}

/**
 * Interface for supporting the 4 phases
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
trait IEventProxy
{
	/**
	Run before anything else. Read your config, create blocks, items, etc,
	 and register them with the GameRegistry.

	 @param event contains information to pre-initialize the mod
	  */
	def preInit(event: FMLPreInitializationEvent)

	/**
	Do your mod setup. Build whatever data structures you care about.
	 Register recipes, send FMLInterModComms messages to other mods.

	 @param event contains information to initialize and finalize the mod
	  */
	def init(event: FMLInitializationEvent)

	/**
	Handle interaction with other mods, complete your setup based on this.

	 @param event Event after setup
	  */
	def postInit(event: FMLPostInitializationEvent)
}
