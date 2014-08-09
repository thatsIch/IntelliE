package de.thatsich.minecraft.common.module.registry


import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.Modules
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class ItemRegistry extends CamelCaseParser
{
	def registerItems(registrable: Modules): Unit =
	{
		registrable.foreach
		{
			case item: Item => this.registerItem(item)
			case _          =>
		}
	}

	private def registerItem(item: Item): Unit =
	{
		GameRegistry.registerItem(item, this.getItemName(item))
	}

	private def getItemName(item: Item): String =
	{
		val className: String = item.getClass.getSimpleName

		this.parseCamelCase(className)
	}
}
