package de.thatsich.minecraft.common.module.registries

import java.io._

import appeng.api.AEApi
import appeng.api.recipes.{IRecipeHandler, IRecipeLoader}
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.module.recipe.Recipe

/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
trait RecipeRegistry
{
	def registerRecipes( modules: Seq[ Module ] ): Unit =
	{
		for( module <- modules )
		{
			module.moduleParts.foreach
			{
				case recipe: Recipe => this.registerRecipe( recipe )
				case _ =>
			}
		}
	}

	private def registerRecipe( recipe: Recipe ): Unit =
	{
		val recipehandler: IRecipeHandler = AEApi.instance( ).registries( ).recipes( ).createNewRecipehandler( )
		val externalRecipePath: String = recipe.externalPath
		val internalRecipePath: String = recipe.internalPath
		val externalRecipe = new File( externalRecipePath )

		if( externalRecipe.exists( ) )
		{
			recipehandler.parseRecipes( new ExternalRecipeLoader, externalRecipe.getPath )
		}
		else
		{
			recipehandler.parseRecipes( new InternalRecipeLoader, internalRecipePath )
		}

		recipehandler.registerHandlers( )
	}

	private class InternalRecipeLoader extends IRecipeLoader
	{
		def getFile( path: String ): BufferedReader =
		{
			val resourceAsStream: InputStream = getClass.getResourceAsStream( path )
			val reader: InputStreamReader = new InputStreamReader( resourceAsStream, "UTF-8" )

			new BufferedReader( reader )
		}
	}

	private class ExternalRecipeLoader extends IRecipeLoader
	{
		def getFile( path: String ): BufferedReader =
		{
			new BufferedReader( new FileReader( new File( path ) ) )
		}
	}

}
