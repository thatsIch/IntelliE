package de.thatsich.minecraft.common.module.registry


import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.Modules
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import net.minecraft.item.Item


/**
 * Registry for items
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class ItemRegistry(registrable: Modules, log: Log) extends CamelCaseParser with Registry
{
	/**
	 * Registers all items in modules
	 */
	def registerAll(): Unit =
	{
		for (module: Module <- this.registrable; item <- module.items)
		{
			this.register(item)
		}
	}

	/**
	 * Registers a single item
	 *
	 * @param item to be registered item
	 */
	private def register(item: Item): Unit =
	{
		GameRegistry.registerItem(item, this.getItemName(item))
	}

	/**
	 * Gets the name which will be stored in the end in the registry
	 *
	 * @param item to be extracted name of item
	 *
	 * @return stripped down version of the itemname
	 */
	private def getItemName(item: Item): String =
	{
		val className: String = item.getClass.getSimpleName

		this.parseCamelCase(className)
	}
}
