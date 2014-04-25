package de.thatsich.minecraft

import de.thatsich.minecraft.core.ModuleRegistry
import de.thatsich.minecraft.core.config.IConfig
import de.thatsich.minecraft.core.log.{Log, ILog}
import de.thatsich.minecraft.core.module.IModule
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
	implicit final val modules   : List[ IModule ] = List( )
	implicit final val configs   : List[ IConfig ] = List( )
	implicit final val registries: ModuleRegistry  = new ModuleRegistry
}
