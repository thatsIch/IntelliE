package de.thatsich.minecraft.integration.applied.aerodynamics


import codechicken.nei.api.API
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module


/**
 *
 *
 * @author thatsIch
 * @since 30.08.2014.
 */
class NEICustomRecipes(modules: Seq[Module], log: Log)
{
	def registerCustomRecipes(): Unit =
	{
		val workbenchHandler: NEIWorkbenchRecipeHandler = new NEIWorkbenchRecipeHandler

		API.registerRecipeHandler(workbenchHandler)
		API.registerUsageHandler(workbenchHandler)
	}
}
