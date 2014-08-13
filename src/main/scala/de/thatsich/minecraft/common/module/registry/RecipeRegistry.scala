package de.thatsich.minecraft.common.module.registry


import java.io._

import appeng.api.AEApi
import appeng.api.recipes.{IRecipeHandler, IRecipeLoader}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.module.recipe.Recipe


/**
 * Registry for recipes
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class RecipeRegistry(registrable: Seq[Module], log: Log)
{
	/**
	 * Registers all recipes in the modules
	 */
	def registerAll(): Unit =
	{
		val recipehandler: IRecipeHandler = AEApi.instance().registries().recipes().createNewRecipehandler()

		for (module: Module <- this.registrable; recipe <- module.recipes)
		{
			this.register(recipehandler, recipe)
		}

		recipehandler.registerHandlers()
	}

	/**
	 * Registers a recipe into a specific recipe handler
	 *
	 * @param recipehandler registering handler
	 * @param recipe to be registered recipe
	 */
	private def register(recipehandler: IRecipeHandler, recipe: Recipe): Unit =
	{
		val externalRecipePath: String = recipe.externalPath
		val internalRecipePath: String = recipe.internalPath
		val externalRecipe = new File(externalRecipePath)

		if (externalRecipe.exists())
		{
			this.log.info("Registring external recipe from " + externalRecipe.getPath)
			recipehandler.parseRecipes(new ExternalRecipeLoader, externalRecipe.getPath)
		}
		else
		{
			this.log.info("Registring internal recipe from " + internalRecipePath)
			recipehandler.parseRecipes(new InternalRecipeLoader, internalRecipePath)
		}
	}

	/**
	 * loads internal recipes from classpath resources
	 */
	private class InternalRecipeLoader extends IRecipeLoader
	{
		def getFile(path: String): BufferedReader =
		{
			val resourceAsStream: InputStream = getClass.getResourceAsStream(path)
			val reader: InputStreamReader = new InputStreamReader(resourceAsStream, "UTF-8")

			new BufferedReader(reader)
		}
	}

	/**
	 * loads external recipes from file
	 */
	private class ExternalRecipeLoader extends IRecipeLoader
	{
		def getFile(path: String): BufferedReader = new BufferedReader(new FileReader(new File(path)))
	}

}
