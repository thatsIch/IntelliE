package de.thatsich.minecraft.common.registries

import de.thatsich.minecraft.common.module.item.IItem
import de.thatsich.minecraft.common.Log

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
object OItemRegistry extends IRegistry[ IItem ]
{
	def add(item: IItem)(implicit log: Log)
	{
		//		this.items.add(item)
		//		this.log.debug("Added Item %s.", item)
	}

	def register()(implicit log: Log)
	{
		//		for( item <- this.items )
		//		{
		//			val unlocalizedName: Nothing = item.getUnlocalizedName
		//			GameRegistry.registerItem(item.asInstanceOf[ Item ], unlocalizedName)
		//			this.log.debug("Registered Item %s with %s", item, unlocalizedName)
		//		}
		//		this.log.info("Registering all Items.")
	}
}
