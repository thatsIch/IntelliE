package de.thatsich.minecraft.core.registries

import de.thatsich.minecraft.core.module.block.{ABlockContainer, IBlockContainer}
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemBlock
import de.thatsich.minecraft.core.log.ILog

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class BlockContainerRegistry(log: ILog)
	extends ARegistry[ IBlockContainer ](log)
{
	def register()
	{
		for( block <- this.set )
		{
			val container: ABlockContainer = block.asInstanceOf[ ABlockContainer ]
			val itemBlockClass: Class[ _ <: ItemBlock ] = container.getItemBlockClass
			val unlocalizedName: String = container.getUnlocalizedName

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
