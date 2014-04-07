package de.thatsich.minecraft.intellie.common.registries

import de.thatsich.minecraft.intellie.common.logger.ILog
import de.thatsich.minecraft.intellie.common.module.block.{ABlockContainer, IBlockContainer}
import cpw.mods.fml.common.registry.GameRegistry

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class BlockContainerRegistry(log: ILog) extends ARegistry[ IBlockContainer ](log)
{
	def register()
	{
		for( block <- this.blockContainers )
		{
			val container: ABlockContainer = block.asInstanceOf[ ABlockContainer ]
			val itemBlockClass: Nothing = container.getItemBlockClass
			val unlocalizedName: Nothing = container.getUnlocalizedName
			if( itemBlockClass != null )
			{
				GameRegistry.registerBlock(container, itemBlockClass, unlocalizedName)
			}
			else
			{
				GameRegistry.registerBlock(container, unlocalizedName)
			}
			this.log.debug("Registered BlockContainer %s", block)
		}
		this.log.info("Finished registering Blocks and BlockContainer.")
	}
}
