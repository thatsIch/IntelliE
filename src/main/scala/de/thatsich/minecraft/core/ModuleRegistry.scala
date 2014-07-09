package de.thatsich.minecraft.core

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.api.mod.InitEventHandler
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.core.module.Module

/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
class ModuleRegistry( implicit modules: List[ Module ], log: Log )
	extends InitEventHandler
{
	var entityID: Int = 0

	for( module <- this.modules )
	{
		(module.item, module.block, module.tileEntity, module.entity) match
		{
			case (Some( item ), None, None, None) => GameRegistry.registerItem( item, item.getUnlocalizedName )
			case (None, Some( block ), None, None) => GameRegistry.registerBlock( block, block.getUnlocalizedName )
			//			case (None, None, Some( tileEntity ), None) => GameRegistry.registerTileEntity( null )
			//			case (None, None, None, Some( enity )) => EntityRegistry.registerModEntity( ) entityclass.class, instane
			case _ => log.severe( s"Unknown Module $module" )
		}
		//		RenderingRegistry.registerBlockHandler() ISBRH
		//		RenderingRegistry.registerEntityRenderingHandler() Entity.class, Render
	}

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	def preInit( event: FMLPreInitializationEvent ): Unit =
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
