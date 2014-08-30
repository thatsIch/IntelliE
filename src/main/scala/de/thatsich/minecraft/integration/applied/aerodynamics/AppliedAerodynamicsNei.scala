package de.thatsich.minecraft.integration.applied.aerodynamics


import cpw.mods.fml.common.Mod
import de.thatsich.minecraft.common.log.SimpleLog
import de.thatsich.minecraft.common.string.Abbreviation


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
	final val version = "@version@"
	final val dependencies = "after:appaero;after:NotEnoughItems"

	val abbr = new Abbreviation("Aero|NEI")
	val log = new SimpleLog(abbr)
}
