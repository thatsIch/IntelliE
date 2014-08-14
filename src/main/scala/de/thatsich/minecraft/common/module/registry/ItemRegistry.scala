package de.thatsich.minecraft.common.module.registry


import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import net.minecraft.item.Item


/**
 * Registry for items
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class ItemRegistry(registrable: Seq[Module], log: Log) extends CamelCaseParser
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

		this.log.info(s"Finished loading ${this.registrable.length} item(s).")
	}

	/**
	 * Registers a single item
	 *
	 * @param item to be registered item
	 */
	private def register(item: Item): Unit =
	{
		val name: String = this.getItemName(item)
		val simpleClassName: String = item.getClass.getSimpleName

		this.log.debug(s"Adding item $simpleClassName with name $name")
		GameRegistry.registerItem(item, name)
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
		val unlocalizedName: String = item.getUnlocalizedName
		val position: Int = unlocalizedName.lastIndexOf('.') + 1
		val name : String = unlocalizedName.substring(position)

		name
	}
}
