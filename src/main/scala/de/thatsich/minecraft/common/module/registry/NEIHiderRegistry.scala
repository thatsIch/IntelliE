package de.thatsich.minecraft.common.module.registry


import java.lang.reflect.{InvocationTargetException, Method}

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import net.minecraft.item.{Item, ItemStack}


/**
 * Responsible to hide marked items from NEI.
 * Logs the outcome to debug
 *
 * @author thatsIch
 * @since 18.08.2014.
 *
 * @param registrable modules
 * @param log logger
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
			val hideItemMethod = api.getMethod("hideItem", classOf[ItemStack])

			this.iterateAll(hideItemMethod)
		}
		catch
			{
				case e: ClassNotFoundException => this.log.warn("NEI API not found. Disabling NEI Hiding integration.")
				case m: NoSuchMethodException  => this.log.warn("NEI method 'hideItem' not found. Disabling NEI Hiding integration.")
				case s: SecurityException      => this.log.warn("NEI method 'hideItem' was inaccessible. Disabling NEI Hiding integration.")
			}
	}

	/**
	 * Iterates over all modules to apply a hideItem Method on all of them
	 *
	 * @param hideItemMethod applied method
	 */
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

		try
		{
			this.log.debug(s"Hide item $simpleClassName from NEI")
			hideItemMethod.invoke(null, new ItemStack(item))
		}
		catch
			{
				case access: IllegalAccessException     => this.log.warn("Illegal access to 'hideItem'.")
				case argument: IllegalArgumentException => this.log.warn("Illegal args for 'hideItem'.")
				case invoke: InvocationTargetException  => this.log.warn("Could not invoke 'hideItem'. ")
			}
	}
}
