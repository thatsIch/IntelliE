package de.thatsich.minecraft.intellie.common.registries

import de.thatsich.minecraft.intellie.common.logger.ILog
import cpw.mods.fml.client.registry.RenderingRegistry

/**
 * Registry for armor rendering
 * Add an armor to it which
 * will be registered into the actual registry
 * in pre-init automatically
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class ArmorRenderingRegistry(log: ILog)
	extends ARegistry[ String ](log)
{
	def register()
	{
		for( armor <- this.set )
		{
			RenderingRegistry.addNewArmourRendererPrefix(armor)
		}
		this.log.info("Registered all ArmorRenderers")
	}
}
