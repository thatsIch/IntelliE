package de.thatsich.minecraft

import de.thatsich.minecraft.api.mod.config.Config
import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.module.{Module, ModuleRegistry}
import de.thatsich.minecraft.api.mod.network.PacketPipeline
import de.thatsich.minecraft.intellie.intern.{IELog, IEPacketPipeline}

/**
 * all dependencies for IE
 *
 * @author thatsIch
 * @since 25.04.2014.
 */
package object intellie
{
	implicit final val log: Log = IELog

	// requires Log
	implicit final val pipeline: PacketPipeline = IEPacketPipeline
	implicit final val modules   : List[ Module ] = List( )
	implicit final val configs   : List[ Config ] = List( )

	// requires Modules, Log
	implicit final val registries: ModuleRegistry = new ModuleRegistry
}
