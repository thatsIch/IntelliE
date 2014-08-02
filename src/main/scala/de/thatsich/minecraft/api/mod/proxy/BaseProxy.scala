package de.thatsich.minecraft.api.mod.proxy

import java.io._

import appeng.api.AEApi
import appeng.api.recipes.{IRecipeHandler, IRecipeLoader}
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.api.mod.BaseConfigPath

/**
 *
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
abstract class BaseProxy extends Proxy
{
	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	def preInit( event: FMLPreInitializationEvent ): Unit =
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
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	def postInit( event: FMLPostInitializationEvent ): Unit =
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
			val resourceAsStream: InputStream = getClass.getResourceAsStream( s"/assets/appaero/recipes/$name" )
			if (resourceAsStream == null ) {
				println("shiet?")
			}
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

	private class ExternalRecipePath extends BaseConfigPath( "config", "AppliedEnergistics2", "IntelliE", "Aero", "dissembler.recipe" )

}
