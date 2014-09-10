package de.thatsich.minecraft.intellie.applied.aeronei


import codechicken.nei.api.IConfigureNEI
import de.thatsich.minecraft.common.Module
import de.thatsich.minecraft.common.log.SimpleLog
import de.thatsich.minecraft.common.string.BaseAbbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamicsAPI
import net.minecraft.item.Item

import scala.collection.mutable.ArrayBuffer


/**
 * if you name it NEI___Config and implement IConfigureNEI
 * it will be automatically loaded by NEI
 * not the cleanest way but it works..
 *
 * @author thatsIch
 * @since 30.08.2014.
 */
class NEIAppAeroConfig extends IConfigureNEI
{
	override def loadConfig(): Unit =
	{
		val abbr = new BaseAbbreviation("Aero|NEI")
		val log = new SimpleLog(abbr)

		val vectorized: Seq[Module] = AppliedAerodynamicsAPI.instance.proxy.modules.vectorized
		val fakes: Seq[Item] = this.extractFakes(vectorized)

		val hider = new NEIFakeHider(fakes, log)
		val explanation = new NEICustomExplanations(null, log)
		val recipes = new NEICustomRecipes(log)

		hider.hideItemsInNEI()
		explanation.registerCustomExplanations()
		recipes.registerCustomRecipes()
	}

	private def extractFakes(vectorized: Seq[Module]): Seq[Item] =
	{
		val buffer = new ArrayBuffer[Item]()

		vectorized.foreach(module =>
		{
			buffer ++= module.definitions.fakes
		})

		buffer.toVector
	}

	override def getName: String = AppliedAerodynamicsNei.id

	override def getVersion: String = AppliedAerodynamicsNei.version
}
