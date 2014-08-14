package de.thatsich.minecraft.common.module.registry


import appeng.api.AEApi
import appeng.api.features.IRecipeHandlerRegistry
import appeng.api.recipes.ICraftHandler
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module


/**
 * Registry for craft handlers
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
class CraftHandlerRegistry(registrable: Seq[Module], log: Log)
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

		this.log.info(s"Finished loading ${this.registrable.length} craft handler(s).")
	}

	/**
	 * Adds the craft handler class into the registry
	 * @param handler to be added handler
	 * @param registry into registry
	 */
	private def register(handler: Class[_ <: ICraftHandler], registry: IRecipeHandlerRegistry): Unit =
	{
		val name: String = handler.getSimpleName
		val simpleClassName: String = handler.getSimpleName
		val stripped: String = this.stripCraftHandlerFromName(name)

		this.log.debug(s"Adding craft handler $simpleClassName with name: $stripped")
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
