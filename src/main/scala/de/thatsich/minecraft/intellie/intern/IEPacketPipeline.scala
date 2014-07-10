package de.thatsich.minecraft.intellie.intern

import de.thatsich.minecraft.api.mod.log.Log
import de.thatsich.minecraft.api.mod.network.PacketPipeline

/**
 *
 *
 * @author thatsIch
 * @since 10.07.2014.
 */
object IEPacketPipeline extends IEPacketPipeline

class IEPacketPipeline( implicit log: Log ) extends PacketPipeline( log )
