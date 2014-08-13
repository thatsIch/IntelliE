package de.thatsich.minecraft.common.module.registry


import appeng.api.AEApi
import appeng.api.features.IRecipeHandlerRegistry
import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.Modules
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module


/**
 * Registry for craft handlers
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
class CraftHandlerRegistry(registrable: Modules, log: Log) extends Registry
{
	/**
	 * Registers all the craft handlers into AE2 registry
	 */
	def registerAll(): Unit =
	{
		val registry: IRecipeHandlerRegistry = AEApi.instance().registries().recipes()

		for (module: Module <- this.registrable; crafthandler <- module.crafthandlers)
		{
			this.register(crafthandler, registry)
		}
	}

	/**
	 * Adds the craft handler class into the registry
	 * @param handler to be added handler
	 * @param registry into registry
	 */
	private def register(handler: Class[ICraftHandler], registry: IRecipeHandlerRegistry): Unit =
	{
		val name: String = handler.getSimpleName
		val stripped: String = this.stripCraftHandlerFromName(name)

		registry.addNewCraftHandler(stripped, handler)
	}

	/**
	 * Strips craft handler from its class name
	 *
	 * @param name full craft handler name
	 *
	 * @return stripped craft handler name
	 */
	private def stripCraftHandlerFromName(name: String): String =
	{
		val lowerCase: String = name.toLowerCase
		val stripped: String = lowerCase.replace("crafthandler", "")

		if (stripped.length == lowerCase.length)
		{
			this.log.severe(s"Found unconform name for a craft handler: $name")
		}

		stripped
	}
}
