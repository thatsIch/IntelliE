package de.thatsich.minecraft.common.module.registry


import codechicken.nei.api.API
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
class NEIHiderRegistry(registrable: Seq[Module], log: Log)
{
	/**
	 * Registers all items in modules
	 */
	def registerAll(): Unit =
	{
		var length = 0

		for (module: Module <- this.registrable; item <- module.items)
		{
			if (item.getToolClasses(null).contains("fake"))
			{
				this.register(item)
				length += 1
			}
		}

		this.log.info(s"Finished hiding $length item(s).")
	}

	/**
	 * Registers a single item
	 *
	 * @param item to be registered item
	 */
	private def register(item: Item): Unit =
	{
		val simpleClassName: String = item.getClass.getSimpleName

		this.log.debug(s"Hide item $simpleClassName from NEI")
		API.hideItem(new ItemStack(item))
	}
}
