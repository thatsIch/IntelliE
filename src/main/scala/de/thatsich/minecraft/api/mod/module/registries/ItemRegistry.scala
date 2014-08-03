package de.thatsich.minecraft.api.mod.module.registries

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.api.mod.module.Module
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
trait ItemRegistry
{
	def registerItems( modules: Seq[ Module ] ): Unit =
	{
		for( module <- modules )
		{
			module.moduleParts.foreach
			{
				case item: Item => this.registerItem( item )
				case _ =>
			}
		}
	}

	private def registerItem( item: Item ): Unit =
	{
		GameRegistry.registerItem( item, item.getUnlocalizedName )
	}
}
