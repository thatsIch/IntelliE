package de.thatsich.minecraft.common.proxy.module.registry


import java.io._

import appeng.api.AEApi
import appeng.api.recipes.{IRecipeHandler, IRecipeLoader}
import de.thatsich.minecraft.common.Recipe
import de.thatsich.minecraft.common.log.Log


/**
 * Registry for recipes
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class RecipeRegistry(registrable: Seq[Recipe], log: Log)
{
	/**
	 * Registers all recipes in the modules
	 */
	def registerAll(): Unit =
	{
		val recipehandler: IRecipeHandler = AEApi.instance().registries().recipes().createNewRecipehandler()
		this.registrable.foreach(this.register(recipehandler, _))
		this.log.info(s"Finished loading ${this.registrable.length} recipe(s).")
		recipehandler.injectRecipes()
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
			this.log.debug("> Registring external recipe from " + externalRecipe.getPath)
			recipehandler.parseRecipes(new ExternalRecipeLoader, externalRecipe.getPath)
		}
		else
		{
			this.log.debug("> Registring internal recipe from " + internalRecipePath)
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
