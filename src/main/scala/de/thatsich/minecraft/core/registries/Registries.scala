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
	val armorRenderers = new ArmorRenderingRegistry
	val items          = new ItemRegistry

	def preInit(event: FMLPreInitializationEvent)
	{
		this.items.register()
	}

	def init(event: FMLInitializationEvent)
	{

	}

	def postInit(event: FMLPostInitializationEvent)
	{

	}
}
