package de.thatsich.minecraft.common.module.registry


import appeng.api.features.{IRecipeHandlerRegistry, IRegistryContainer}
import appeng.api.recipes.ICraftHandler
import appeng.api.{AEApi, IAppEngApi}
import de.thatsich.minecraft.common.Modules
import de.thatsich.minecraft.common.log.Log


/**
 *
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
class CraftHandlerRegistry(log: Log)
{
	def registerCraftHandlers(registrable: Modules): Unit =
	{
		registrable.foreach
		{
			case handler: Class[ICraftHandler] => this.registerCraftHandler(handler)
			case _                                  =>
		}
	}

	private def registerCraftHandler(handler: Class[ICraftHandler]): Unit =
	{
		val api: IAppEngApi = AEApi.instance()
		val registries: IRegistryContainer = api.registries()
		val recipes: IRecipeHandlerRegistry = registries.recipes()

		val name: String = handler.getSimpleName
		val stripped: String = this.stripCraftHandlerFromName(name)

		recipes.addNewCraftHandler(stripped, handler)
	}

	private def stripCraftHandlerFromName(name: String): String =
	{
		val lowerCase: String = name.toLowerCase
		val stripped: String = lowerCase.replace("crafthandler", "")

		if (stripped.length == lowerCase.length)
		{
			this.log.severe(s"Found anconform name for a craft handler: $name")
		}

		stripped
	}
}
