package de.thatsich.minecraft.integration.applied.aeronei


import cpw.mods.fml.common.event.FMLServerStartingEvent
import cpw.mods.fml.common.{Mod, Optional}


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

	println("NEI THERE")

	@Optional.Method(modid = AppliedAerodynamicsNei.id)
	@Mod.EventHandler
	def onServerStarting(event: FMLServerStartingEvent): Unit =
	{
		new NEIItemHider
	}
}
