package de.thatsich.minecraft.core.registries

import de.thatsich.minecraft.core.module.item.IItem
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.Item
import de.thatsich.minecraft.core.log.Log

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
object OItemRegistry extends ARegistry[ IItem ](new Log("ItemRegistry"))
{
	def register()
	{
		for( item <- this.set )
		{
			val unlocalizedName = item.getUnlocalizedName

			GameRegistry.registerItem(item.asInstanceOf[ Item ], unlocalizedName)
			this.log.debug("Registered Item %s with %s", item, unlocalizedName)
		}
		this.log.info("Registering all Items.")
	}
}
