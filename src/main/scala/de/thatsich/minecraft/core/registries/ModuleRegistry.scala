package de.thatsich.minecraft.core.registries

import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.core.IEventProxy
import de.thatsich.minecraft.core.module.IModule

/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
class ModuleRegistry( implicit modules: List[ IModule ] )
	extends IEventProxy
{
	var entityID: Int = 0

	for( module <- this.modules )
	{
		val oItem = module.item
		val oBlock = module.block
		val oTileEntity = module.tileEntity
		val oEntity = module.entity

		(oItem, oBlock, oTileEntity, oEntity) match
		{
			case (Some( item ), None, None, None) => GameRegistry.registerItem( item )
			case (None, Some( block ), None, None) => GameRegistry.registerBlock( block, block.getUnlocalizedName )
			//			case (None, None, Some( tileEntity ), None) => GameRegistry.registerTileEntity( null )
			//			case (None, None, None, Some( enity )) => EntityRegistry.registerModEntity( ) entityclass.class, instane
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
