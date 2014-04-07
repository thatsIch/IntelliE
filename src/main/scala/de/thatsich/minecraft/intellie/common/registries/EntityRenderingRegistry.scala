package de.thatsich.minecraft.intellie.common.registries

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class EntityRenderingRegistry
{
	def register()
	{
		for( entity <- this.entities )
		{
			//			EntityRegistry.reg
			this.log.debug("Registered %s", entity)
		}
		this.log.info("Registered all Entities")
	}
}
