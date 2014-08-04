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
trait ItemRegistry extends CamelCaseParser
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
		GameRegistry.registerItem( item, this.getItemName( item ) )
	}

	private def getItemName( item: Item ): String =
	{
		val className: String = item.getClass.getSimpleName

		this.parseCamelCase( className )
	}
}
