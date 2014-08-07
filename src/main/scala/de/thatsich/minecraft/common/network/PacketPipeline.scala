package de.thatsich.minecraft.common.network

import java.util

import cpw.mods.fml.common.FMLCommonHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.network.internal.FMLProxyPacket
import cpw.mods.fml.common.network.{FMLOutboundHandler, NetworkRegistry}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.EventProxy
import io.netty.buffer.Unpooled
import io.netty.channel.{ChannelHandler, ChannelHandlerContext}
import io.netty.handler.codec.MessageToMessageCodec
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}
import net.minecraft.network.NetHandlerPlayServer

import scala.collection.mutable

/**
 *
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
@ChannelHandler.Sharable
class PacketPipeline( log: Log ) extends MessageToMessageCodec[ FMLProxyPacket, Packet ] with EventProxy
{
	type PacketClass = Class[ _ <: Packet ]
	private[ this ] val channels          = NetworkRegistry.INSTANCE.newChannel( "base", this )
	private[ this ] val packets           = new mutable.MutableList[ PacketClass ]
	private[ this ] var isPostInitialized = false

	/**
	 * Register your packet with the pipeline. Discriminators are automatically set.
	 *
	 * @param clazz the class to register
	 *
	 * @return whether registration was successful. Failure may occur if 256 packets have been registered or if the registry already contains this packet
	 */
	def register( clazz: PacketClass ): Boolean =
	{
		if( this.packets.size > 256 )
		{
			this.log.severe( "Packet amount exceeded" )
			return false
		}

		if( this.packets.contains( clazz ) )
		{
			this.log.severe( "Packet already registered" )
			return false
		}

		if( this.isPostInitialized )
		{
			this.log.severe( "Already post initialized" )
			return false
		}

		this.packets += clazz

		true
	}

	/**
	 * In line decoding and handling of the packet
	 *
	 * @param ctx context
	 * @param msg message
	 * @param out out
	 */
	def decode( ctx: ChannelHandlerContext, msg: FMLProxyPacket, out: util.List[ AnyRef ] ): Unit =
	{
		val payload = msg.payload( )
		val discriminator = payload.readByte( )
		val maybeClazz: Option[ PacketClass ] = this.packets.get( discriminator )
		val clazz = maybeClazz match
		{
			case Some( value ) => value
			case None => throw new NullPointerException( "No packet registered for discriminator: " + discriminator )
		}

		val packet = clazz.newInstance( )
		packet.decodeInto( ctx, payload.slice( ) )

		FMLCommonHandler.instance( ).getEffectiveSide match
		{
			case Side.CLIENT =>
				val player = this.getClientPlayer
				packet.handleClientSide( player )

			case Side.SERVER =>
				val netHandler = ctx.channel( ).attr( NetworkRegistry.NET_HANDLER ).get( )
				val player = netHandler.asInstanceOf[ NetHandlerPlayServer ].playerEntity
				packet.handleServerSide( player )

			case default =>
		}

		out.add( packet )
	}

	@SideOnly( Side.CLIENT )
	private def getClientPlayer: EntityPlayer =
	{
		Minecraft.getMinecraft.thePlayer
	}

	/**
	 * Send this message to everyone.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 *
	 * @param packet The message to send
	 */
	def sendToAll( packet: Packet ): Unit =
	{
		this.channels.get( Side.SERVER ).attr( FMLOutboundHandler.FML_MESSAGETARGET ).set( FMLOutboundHandler.OutboundTarget.ALL )
		this.channels.get( Side.SERVER ).writeAndFlush( packet )
	}

	/**
	 * Send this message to the specified player.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 *
	 * @param packet The message to send
	 * @param player  The player to send it to
	 */
	def sendTo( packet: Packet, player: EntityPlayerMP ): Unit =
	{
		this.channels.get( Side.SERVER ).attr( FMLOutboundHandler.FML_MESSAGETARGET ).set( FMLOutboundHandler.OutboundTarget.PLAYER )
		this.channels.get( Side.SERVER ).attr( FMLOutboundHandler.FML_MESSAGETARGETARGS ).set( player )
		this.channels.get( Side.SERVER ).writeAndFlush( packet )
	}

	/**
	 * Send this message to everyone within a certain range of a point.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 *
	 * @param packet The message to send
	 * @param point   The { @link cpw.mods.fml.common.network.NetworkRegistry.TargetPoint} around which to send
	 */
	def sendToAllAround( packet: Packet, point: NetworkRegistry.TargetPoint ): Unit =
	{
		this.channels.get( Side.SERVER ).attr( FMLOutboundHandler.FML_MESSAGETARGET ).set( FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT )
		this.channels.get( Side.SERVER ).attr( FMLOutboundHandler.FML_MESSAGETARGETARGS ).set( point )
		this.channels.get( Side.SERVER ).writeAndFlush( packet )
	}

	/**
	 * Send this message to everyone within the supplied dimension.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 *
	 * @param packet     The message to send
	 * @param dimensionId The dimension id to target
	 */
	def sendToDimension( packet: Packet, dimensionId: Int ): Unit =
	{
		this.channels.get( Side.SERVER ).attr( FMLOutboundHandler.FML_MESSAGETARGET ).set( FMLOutboundHandler.OutboundTarget.DIMENSION )
		this.channels.get( Side.SERVER ).attr( FMLOutboundHandler.FML_MESSAGETARGETARGS ).set( dimensionId.asInstanceOf[ Object ] )
		this.channels.get( Side.SERVER ).writeAndFlush( packet )
	}

	/**
	 * Send this message to the server.
	 * <p/>
	 * Adapted from CPW's code in cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
	 *
	 * @param packet The message to send
	 */
	def sendToServer( packet: Packet ): Unit =
	{
		this.channels.get( Side.CLIENT ).attr( FMLOutboundHandler.FML_MESSAGETARGET ).set( FMLOutboundHandler.OutboundTarget.TOSERVER )
		this.channels.get( Side.CLIENT ).writeAndFlush( packet )
	}

	/**
	 * In line encoding of the packet, including discriminator setting
	 *
	 * @param ctx context
	 * @param msg message
	 * @param out out
	 */
	def encode( ctx: ChannelHandlerContext, msg: Packet, out: util.List[ AnyRef ] ): Unit =
	{
		val buffer = Unpooled.buffer( )
		val clazz = msg.getClass

		if( !this.packets.contains( clazz ) )
		{
			throw new NullPointerException( "No Packet Registered for: " + msg.getClass.getCanonicalName )
		}

		val discriminator = this.packets.indexOf( clazz ).asInstanceOf[ Byte ]
		buffer.writeByte( discriminator )
		msg.encodeInto( ctx, buffer )

		val proxyPacket = new FMLProxyPacket( buffer.copy( ), ctx.channel( ).attr( NetworkRegistry.FML_CHANNEL ).get( ) )
		out.add( proxyPacket )
	}

	/**
	 * Handle interaction with other mods, complete your setup based on this.
	 *
	 * @param event Event after setup
	 */
	def postInit( event: FMLPostInitializationEvent ): Unit =
	{
		if( this.isPostInitialized ) return

		this.isPostInitialized = true

		this.packets.sortWith( _.getCanonicalName <= _.getCanonicalName )
	}

	/**
	 * Do your mod setup. Build whatever data structures you care about.
	 * Register recipes, send FMLInterModComms messages to other mods.
	 *
	 * @param event contains information to initialize and finalize the mod
	 */
	def init( event: FMLInitializationEvent ): Unit =
	{

	}

	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	def preInit( event: FMLPreInitializationEvent ): Unit =
	{

	}
}
