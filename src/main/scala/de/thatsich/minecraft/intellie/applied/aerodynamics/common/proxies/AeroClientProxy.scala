package de.thatsich.minecraft.intellie.applied.aerodynamics.common.proxies

import cpw.mods.fml.common.event.FMLPreInitializationEvent

/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
class AeroClientProxy extends AeroCommonProxy
{
	private def initSounds( ): Unit =
	{

	}

	private def initRenderers( ): Unit =
	{

	}

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
	}
}
