package de.thatsich.minecraft

import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.registries.{ORegistries, IRegistries}
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.intellie.common.OIntelliConfigFiles

/**
 *
 *
 * @author thatsIch
 * @since 10.04.2014.
 */
package object intellie
{
	implicit val log: ILog = new Log("IE")
	implicit val registries: IRegistries = ORegistries
	implicit val configFiles: IConfigFiles = OIntelliConfigFiles
}
