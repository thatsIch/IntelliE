package de.thatsich.minecraft.core.registries

import cpw.mods.fml.client.registry.{ISimpleBlockRenderingHandler, RenderingRegistry}
import de.thatsich.minecraft.core.log.ILog

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class BlockRenderingRegistry(log: ILog)
	extends ARegistry[ ISimpleBlockRenderingHandler ](log)
{
	def register()
	{
		for( handler <- this.set )
		{
			RenderingRegistry.registerBlockHandler(handler)
		}
		this.log.info("Registered all BlockRenderers")
	}
}
