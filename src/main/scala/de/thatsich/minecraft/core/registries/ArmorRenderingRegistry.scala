package de.thatsich.minecraft.core.registries

import cpw.mods.fml.client.registry.RenderingRegistry
import de.thatsich.minecraft.core.log.ILog

/**
 * Registry for armor rendering
 * Add an armor to it which
 * will be registered into the actual registry
 * in pre-init automatically
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
final class ArmorRenderingRegistry(implicit log: ILog)
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
