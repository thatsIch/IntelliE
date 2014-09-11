package de.thatsich.minecraft.intellie.applied.aeronei


import codechicken.nei.api.IConfigureNEI
import com.google.common.base.Stopwatch
import de.thatsich.minecraft.common.Module
import de.thatsich.minecraft.common.log.SimpleLog
import de.thatsich.minecraft.common.string.BaseAbbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamicsAPI
import net.minecraft.item.{ItemStack, Item}

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

		val stopwatch: Stopwatch = Stopwatch.createUnstarted
		log.info("ClientStart Begin")
		stopwatch.start

		val apiproxy = AppliedAerodynamicsAPI.proxy
		log.debug(s"Extracted API ($stopwatch).")

		val nbtkeys: Iterable[ItemStack] = apiproxy.nbtkeyregistry.allKeysAsItemStack
		log.debug(s"Extracted NBT Keys ($stopwatch).")

		val vectorized: Seq[Module] = apiproxy.modules.vectorized
		log.debug(s"Extracted Modules ($stopwatch).")

		val fakes: Seq[Item] = this.extractFakes(vectorized)
		log.debug(s"Extracted Fakes ($stopwatch).")

		val fakeStacks = fakes.map(new ItemStack(_))
		log.debug(s"Extracted fake Stacks ($stopwatch).")

		val nbtkeyHider = new NEIItemStackHider(nbtkeys, log)
		val fakeHider = new NEIItemStackHider(fakeStacks, log)
		val explanation = new NEICustomExplanations(null, log)
		val recipes = new NEICustomRecipes(log)

		log.debug(s"Created all processing ($stopwatch).")

		nbtkeyHider.hideItemsInNEI()
		fakeHider.hideItemsInNEI()
		explanation.registerCustomExplanations()
		recipes.registerCustomRecipes()

		log.debug(s"Finished processing ($stopwatch).")

		stopwatch.stop()
		log.info(s"ClientStart End ($stopwatch)")
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
