package de.thatsich.minecraft.core.registries

import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import de.thatsich.minecraft.core.log.ILog

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
class Registries(implicit log: ILog)
	extends IRegistries
{
	lazy val armorRenderers = new ArmorRenderingRegistry

	def preInit(event: FMLPreInitializationEvent)
	{

	}

	def init(event: FMLInitializationEvent)
	{

	}

	def postInit(event: FMLPostInitializationEvent)
	{

	}
}
