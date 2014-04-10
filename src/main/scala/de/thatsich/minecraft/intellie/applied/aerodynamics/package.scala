package de.thatsich.minecraft.intellie.applied

import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.registries.{ORegistries, IRegistries}
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.OAeroConfigFiles

/**
 *
 *
 * @author thatsIch
 * @since 10.04.2014.
 */
package object aerodynamics
{
	implicit val log: ILog = new Log("Aero")
	implicit val registries: IRegistries = ORegistries
	implicit val configFiles: IConfigFiles = OAeroConfigFiles
}
