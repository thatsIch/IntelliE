package de.thatsich.minecraft.core.network

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import net.minecraft.entity.player.EntityPlayer

/**
 * AbstractPacket class. Should be the parent of all packets wishing to use the PacketPipeline.
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
trait IPacket
{
	/**
	 * Encode the packet data into the ByteBuf stream. Complex data sets may need specific data handlers (See @link{cpw.mods.fml.common.network.ByteBuffUtils})
	 *
	 * @param context    channel context
	 * @param buffer the buffer to encode into
	 */
	def encodeInto(context: ChannelHandlerContext, buffer: ByteBuf)

	/**
	 * Decode the packet data from the ByteBuf stream. Complex data sets may need specific data handlers (See @link{cpw.mods.fml.common.network.ByteBuffUtils})
	 *
	 * @param context    channel context
	 * @param buffer the buffer to decode from
	 */
	def decodeInto(context: ChannelHandlerContext, buffer: ByteBuf)

	/**
	 * Handle a packet on the client side. Note this occurs after decoding has completed.
	 *
	 * @param player the player reference
	 */
	def handleClientSide(player: EntityPlayer)

	/**
	 * Handle a packet on the server side. Note this occurs after decoding has completed.
	 *
	 * @param player the player reference
	 */
	def handleServerSide(player: EntityPlayer)
}
