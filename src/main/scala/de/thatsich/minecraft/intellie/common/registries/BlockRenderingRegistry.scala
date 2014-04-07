package de.thatsich.minecraft.intellie.common.registries

import cpw.mods.fml.client.registry.RenderingRegistry

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class BlockRenderingRegistry
{
	def register()
	{
		for( handler <- this.blockRenderers )
		{
			RenderingRegistry.registerBlockHandler(handler)
		}
		this.log.info("Registered all BlockRenderers")
	}
}
