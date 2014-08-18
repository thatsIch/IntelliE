package de.thatsich.minecraft.common.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Interface for supporting the 4 intialisation phases
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
public interface EventProxy
{
	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	void onPreInit(FMLPreInitializationEvent event);

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	void onInit(FMLInitializationEvent event);

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	void onPostInit(FMLPostInitializationEvent event);

	/**
	 * Handles generally client stuff when server started
	 *
	 * @param event event when server is starting
	 */
	void onServerStarting(FMLServerStartingEvent event);
}
