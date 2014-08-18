package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.proxy


import cpw.mods.fml.common.event.FMLPreInitializationEvent


/**
 *
 *
 * @author thatsIch
 * @since 04.04.2014.
 */
final class AeroClientProxy extends AeroCommonProxy
{

	override def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit =
	{
		this.initRenderers()
		this.initSounds()

		super.onInheritatedPreInit(event)
	}

	private def initSounds(): Unit =
	{
	}

	private def initRenderers(): Unit =
	{
	}
}
