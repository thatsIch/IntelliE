package de.thatsich.intellie.applied.aerodynamics;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Interface for supporting the 4 phases
 *
 * @author thatsIch
 * @date 17.03.14.
 */
public interface IProxy
{
	/**
	 * Phase 1
	 *
	 * @param event preinit event
	 */
	void preInit ( FMLPreInitializationEvent event );

	/**
	 * Phase 2
	 *
	 * @param event init event
	 */
	void init ( FMLInitializationEvent event );

	/**
	 * Phase 3
	 *
	 * @param event postinit event
	 */
	void postInit ( FMLPostInitializationEvent event );

	/**
	 * Phase 4
	 *
	 * @param event mod communitcation event
	 */
//	void interMod ( FMLInterModComms event );
}
