package de.thatsich.minecraft.integration.applied.aerodynamics


import codechicken.nei.api.API
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLServerStartingEvent
import de.thatsich.minecraft.common.log.SimpleLog
import de.thatsich.minecraft.common.module.Module
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 19.08.2014.
 */
@Mod(
	modid = AppliedAerodynamicsNei.id,
	name = AppliedAerodynamicsNei.name,
	version = AppliedAerodynamicsNei.version,
	dependencies = AppliedAerodynamicsNei.dependencies,
	modLanguage = "scala"
)
object AppliedAerodynamicsNei
{
	final val id = "appaeronei"
	final val name = "Applied Aerodynamics NEI Integration"
	final val version = "${version}"
	final val dependencies = "after:appaero;after:NotEnoughItems"

	private val abbr = new Abbreviation("Aero|NEI")
	private val log = new SimpleLog(this.abbr)

	@Mod.EventHandler
	def onServerStarting(event: FMLServerStartingEvent): Unit =
	{
		val modules: Seq[Module] = AppliedAerodynamics.proxy.modules
		this.hideItemsInNEI(modules)
		this.registerCustomRecipes(modules)
		this.registerCustomExplanations(modules)
	}

	private def registerCustomExplanations(modules: Seq[Module]): Unit =
	{

	}

	private def registerCustomRecipes(modules: Seq[Module]): Unit =
	{

	}

	private def hideItemsInNEI(modules: Seq[Module]): Unit =
	{
		var counter = 0
		for (module <- modules; item <- module.items)
		{
			if (item.getToolClasses(null).contains("fake"))
			{
				API.hideItem(new ItemStack(item))
				counter += 1
				this.log.debug(s"Hid ${item.getClass.getSimpleName} from NEI.")
			}
		}
		this.log.info(s"Hid $counter elements from NEI.")
	}
}
