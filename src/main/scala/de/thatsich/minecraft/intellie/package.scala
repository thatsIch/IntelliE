package de.thatsich.minecraft

import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.registries.{Registries, IRegistries}
import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.intellie.common.{IntelliModules, OIntelliConfigFiles}
import de.thatsich.minecraft.core.module.IModules

/**
 *
 *
 * @author thatsIch
 * @since 10.04.2014.
 */
package object intellie
{
	implicit val log: ILog = new Log("IE")
	implicit val registries: IRegistries = new Registries
	implicit val configFiles: IConfigFiles = OIntelliConfigFiles
	implicit final val modules: IModules = new IntelliModules
}
