package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy

import java.io._

import appeng.api.AEApi
import appeng.api.recipes.{IRecipeHandler, IRecipeLoader}
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.api.mod.BaseConfigPath
import de.thatsich.minecraft.api.mod.proxy.BaseServerProxy

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
final class AeroServerProxy extends BaseServerProxy
{
	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	def postInit( event: FMLPostInitializationEvent ): Unit =
	{

	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	def init( event: FMLInitializationEvent ): Unit =
	{
		this.registerRecipes( )
	}

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	def preInit( event: FMLPreInitializationEvent ): Unit =
	{

	}

	private def registerRecipes( ): Unit =
	{
		val recipehandler: IRecipeHandler = AEApi.instance( ).registries( ).recipes( ).createNewRecipehandler( )
		val externalRecipePath: String = new ExternalRecipePath
		val externalRecipe = new File( externalRecipePath )

		if( externalRecipe.exists( ) )
		{
			recipehandler.parseRecipes( new ExternalRecipeLoader, externalRecipe.getPath )
		}
		else
		{
			recipehandler.parseRecipes( new InternalRecipeLoader, "main.recipe" )
		}

		recipehandler.registerHandlers( )
	}

	private class InternalRecipeLoader extends IRecipeLoader
	{
		def getFile( name: String ): BufferedReader =
		{
			val resourceAsStream: InputStream = getClass.getResourceAsStream( "assets/appaero/recipes/" + name )
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

	private class ExternalRecipePath extends BaseConfigPath("config", "AppliedEnergistics2", "IntelliE", "Aero", "dissembler.recipe")
}
