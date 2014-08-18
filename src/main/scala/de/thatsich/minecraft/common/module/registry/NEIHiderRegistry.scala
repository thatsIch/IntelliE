package de.thatsich.minecraft.common.module.registry


import java.lang.reflect.Method

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
		val className = "codechicken.nei.api.API"

		try
		{
			val api = java.lang.Class.forName(className)
			val hideItemMethod = api.getDeclaredMethod("hideItem", classOf[ItemStack])

			this.iterateAll(hideItemMethod)
		}
		catch
			{
				case e: ClassNotFoundException => this.log.warn("NEI not found. Disabling NEI Hiding integration.")
			}
	}

	private def iterateAll(hideItemMethod: Method): Unit =
	{
		var length = 0

		for (module: Module <- this.registrable; item <- module.items)
		{
			if (item.getToolClasses(null).contains("fake"))
			{
				this.register(hideItemMethod, item)
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
	private def register(hideItemMethod: Method, item: Item): Unit =
	{
		val simpleClassName: String = item.getClass.getSimpleName

		this.log.debug(s"Hide item $simpleClassName from NEI")
		hideItemMethod.invoke(new ItemStack(item))
	}
}
