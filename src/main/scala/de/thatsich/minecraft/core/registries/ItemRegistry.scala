package de.thatsich.minecraft.core.registries

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.Item
import de.thatsich.minecraft.core.log.ILog

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
final class ItemRegistry(implicit log: ILog)
	extends ARegistry[ Item ](log)
{
	def register()
	{
		for( item <- this.set )
		{
			val unlocalizedName = item.getUnlocalizedName

			GameRegistry.registerItem(item, unlocalizedName)
			this.log.debug("Registered Item %s with %s", item, unlocalizedName)
		}
		this.log.info("Registering all Items.")
	}
}
