package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy

import cpw.mods.fml.common.event.FMLPreInitializationEvent
import de.thatsich.minecraft.api.mod.proxy.BaseClientProxy

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
final class AeroClientProxy extends BaseClientProxy
{
	/**
	 * Run before anything else. Read your config, create blocks, items, etc,
	 * and register them with the GameRegistry.
	 *
	 * @param event contains information to pre-initialize the mod
	 */
	override def preInit( event: FMLPreInitializationEvent ): Unit =
	{
		this.initRenderers( )
		this.initSounds( )

		super.preInit( event )
	}

	private def initSounds( ): Unit =
	{

	}

	private def initRenderers( ): Unit =
	{

	}
}
