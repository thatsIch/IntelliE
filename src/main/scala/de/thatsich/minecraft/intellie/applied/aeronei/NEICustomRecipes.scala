package de.thatsich.minecraft.intellie.applied.aeronei


import codechicken.nei.api.API
import codechicken.nei.recipe.TemplateRecipeHandler
import de.thatsich.minecraft.common.log.Log


/**
 *
 *
 * @author thatsIch
 * @since 30.08.2014.
 */
class NEICustomRecipes(log: Log)
{
	def registerCustomRecipes(): Unit =
	{
		this.registerCustomRecipe(new NEIWorkbenchRecipeHandler, this.log)
	}

	private def registerCustomRecipe(recipe: TemplateRecipeHandler, log: Log): Unit =
	{
		API.registerRecipeHandler(recipe)
		API.registerUsageHandler(recipe)
		log.debug(s"Registered custom recipe $recipe.")
	}
}
