package de.thatsich.minecraft

import de.thatsich.minecraft.core.ModuleRegistry
import de.thatsich.minecraft.core.config.IConfig
import de.thatsich.minecraft.core.log.{ILog, Log}
import de.thatsich.minecraft.core.module.Module
import de.thatsich.minecraft.core.network.PacketPipeline

/**
 *
 *
 * @author thatsIch
 * @since 25.04.2014.
 */
package object intellie
{
	implicit final val log       : ILog            = new Log( "IE" )
	implicit final val pipeline  : PacketPipeline  = new PacketPipeline
	implicit final val modules   : List[ Module ]  = List( )
	implicit final val configs   : List[ IConfig ] = List( )
	implicit final val registries: ModuleRegistry  = new ModuleRegistry
}
