package de.thatsich.minecraft

import de.thatsich.minecraft.core.config.IConfigFiles
import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.module.{IModule, IModules}
import de.thatsich.minecraft.core.network.PacketPipeline
import de.thatsich.minecraft.core.registries.{Registries, IRegistries}
import de.thatsich.minecraft.intellie.common.{IntelliModules, OIntelliConfigFiles}

/**
 *
 *
 * @author thatsIch
 * @since 10.04.2014.
 */
package object intellie
{
	implicit final val log: ILog = new Log( "IE" )
	implicit final val pipeline   : PacketPipeline = new PacketPipeline
	implicit final val registries : IRegistries    = new Registries
	implicit final val configFiles: IConfigFiles   = OIntelliConfigFiles
	implicit final val modules    : IModules       = new IntelliModules
	implicit final val module: List[ IModule ] = List(

	)
}
