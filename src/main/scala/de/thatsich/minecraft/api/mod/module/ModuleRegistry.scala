package de.thatsich.minecraft.api.mod.module

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.proxy.Proxy
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity

/**
 *
 *
 * @author thatsIch
 * @since 23.04.2014.
 */
class ModuleRegistry( modules: Seq[ Module ], log: Log ) extends Proxy
{
	var entityID: Int = 0

	for( module <- this.modules )
	{
		(module.item, module.block, module.tileEntity, module.entity).productIterator.foreach
		{
			case Some( item: Item ) => GameRegistry.registerItem( item, item.getUnlocalizedName )
			case Some( block: Block ) => GameRegistry.registerBlock( block, block.getUnlocalizedName )
			case Some( tileEntity: TileEntity ) => GameRegistry.registerTileEntity( tileEntity.getClass, tileEntity.getClass.toString )
			//			case entity: Entity => EntityRegistry.registerModEntity( entity.getClass, entity.getClass.toString, entity.getEntityId, )

			case None =>

			case any => log.severe( s"Unknown Module $module with $any" )
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
