package de.thatsich.intellie.common.util;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 Interface for supporting the 4 phases

 @author thatsIch
 @date 17.03.14. */
public interface IProxy
{
	/**
	 Run before anything else. Read your config, create blocks, items, etc,
	 and register them with the GameRegistry.

	 @param event contains information to pre-initialize the mod
	 */
	void preInit ( FMLPreInitializationEvent event );

	/**
	 Do your mod setup. Build whatever data structures you care about.
	 Register recipes, send FMLInterModComms messages to other mods.

	 @param event contains information to initialize and finalize the mod
	 */
	void init ( FMLInitializationEvent event );

	/**
	 Handle interaction with other mods, complete your setup based on this.

	 @param event Event after setup
	 */
	void postInit ( FMLPostInitializationEvent event );

	/**
	 * Phase 4
	 *
	 * @param event mod communitcation event
	 */
	//	void interMod ( FMLInterModComms event );
}
