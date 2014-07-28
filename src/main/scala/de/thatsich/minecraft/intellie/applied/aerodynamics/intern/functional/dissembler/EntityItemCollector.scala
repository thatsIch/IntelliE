package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import cpw.mods.fml.common.eventhandler.{EventPriority, SubscribeEvent}
import net.minecraft.entity.Entity
import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.EntityJoinWorldEvent

import scala.collection.mutable.ArrayBuffer

/**
 *
 *
 * @author thatsIch
 * @since 28.07.2014.
 */
class EntityItemCollector
{
	val entityItems : ArrayBuffer[ EntityItem ] = ArrayBuffer( )
	var isCollecting: Boolean                   = false
	MinecraftForge.EVENT_BUS.register( this )

	def startCollecting( ): Unit =
	{
		if( this.isCollecting )
		{
			throw new RuntimeException( "Already collecting items." )
		}

		this.isCollecting = true
	}

	def stopCollecting( ): Unit =
	{
		this.isCollecting = false
	}

	def getCapturedEntities: List[ EntityItem ] =
	{
		this.isCollecting = false

		val newEntityItems: List[ EntityItem ] = entityItems.toList
		entityItems.clear( )

		newEntityItems
	}

	@SubscribeEvent( priority = EventPriority.LOWEST )
	def onEntityJoinWorld( event: EntityJoinWorldEvent ): Unit =
	{
		if( this.isCollecting )
		{
			val entity: Entity = event.entity
			val entityClass: Class[ _ <: Entity ] = entity.getClass
			if( classOf[ EntityItem ].isAssignableFrom( entityClass ) )
			{
				val stack: ItemStack = entity.getDataWatcher.getWatchableObjectItemStack( 10 )
				if( stack == null )
				{
					return
				}
				entityItems += entity.asInstanceOf[ EntityItem ]
				entity.setDead( )
				event.setCanceled( true )
			}
		}
	}
}
