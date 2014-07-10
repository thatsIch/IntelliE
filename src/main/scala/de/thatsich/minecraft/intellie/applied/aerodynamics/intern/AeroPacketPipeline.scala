package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.network.PacketPipeline

/**
 *
 *
 * @author thatsIch
 * @since 10.07.2014.
 */
object AeroPacketPipeline extends AeroPacketPipeline

class AeroPacketPipeline( implicit log: Log ) extends PacketPipeline( log )