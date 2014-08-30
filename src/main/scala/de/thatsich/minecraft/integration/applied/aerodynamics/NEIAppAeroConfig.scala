package de.thatsich.minecraft.integration.applied.aerodynamics


import codechicken.nei.api.IConfigureNEI
import de.thatsich.minecraft.common.log.SimpleLog
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics


/**
 *
 *
 * @author thatsIch
 * @since 30.08.2014.
 */
class NEIAppAeroConfig extends IConfigureNEI
{
	override def loadConfig(): Unit =
	{
		val abbr = new Abbreviation("Aero|NEI")
		val log = new SimpleLog(abbr)

		val modules: Seq[Module] = AppliedAerodynamics.proxy.modules
		val hider = new NEIFakeItemHider(modules, log)
		val explanation = new NEICustomExplanations(modules, log)
		val recipes = new NEICustomRecipes(modules, log)

		hider.hideItemsInNEI()
		explanation.registerCustomExplanations()
		recipes.registerCustomRecipes()
	}

	override def getName: String = AppliedAerodynamicsNei.id

	override def getVersion: String = "1"
}
