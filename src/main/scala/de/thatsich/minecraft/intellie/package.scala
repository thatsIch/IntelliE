package de.thatsich.minecraft

import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.api.mod.log.{BaseLog, Log}
import de.thatsich.minecraft.api.mod.module.{Module, ModuleRegistry}
import de.thatsich.minecraft.api.mod.network.PacketPipeline

/**
 * all dependencies for IE
 *
 * @author thatsIch
 * @since 25.04.2014.
 */
package object intellie
{
	implicit final val log       : Log            = new BaseLog( "IE" )
	implicit final val pipeline  : PacketPipeline = new PacketPipeline
	implicit final val modules   : List[ Module ] = List( )
	implicit final val configs   : List[ Config ] = List( )
	implicit final val registries: ModuleRegistry = new ModuleRegistry
}
