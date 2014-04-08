package de.thatsich.minecraft.intellie.common.registries

import de.thatsich.minecraft.intellie.common.logger.ILog

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class EntityRenderingRegistry(log: ILog)
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
