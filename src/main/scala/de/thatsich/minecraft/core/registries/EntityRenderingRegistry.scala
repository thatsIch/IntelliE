package de.thatsich.minecraft.core.registries

import de.thatsich.minecraft.core.log.ILog

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
final class EntityRenderingRegistry(implicit log: ILog)
	extends ARegistry[ String ](log)
{
	def register()
	{
		for( entity <- this.set )
		{
			//			EntityRegistry.reg
			//			EntityRegistry
			this.log.debug("Registered %s", entity)
		}
		this.log.info("Registered all Entities")
	}
}
