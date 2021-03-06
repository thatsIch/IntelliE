package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy


import cpw.mods.fml.common.event.FMLPreInitializationEvent
import de.thatsich.minecraft.intellie.applied.aerodynamics.AeroCommonProxy


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
