package de.thatsich.minecraft.core.registries

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.core.module.block.{IBlock, ABlock}
import de.thatsich.minecraft.core.log.ILog

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class BlockRegistry(log: ILog)
	extends ARegistry[ IBlock ](log)
{
	def register()
	{
		for( block <- this.set )
		{
			val concreteBlock: ABlock = block.asInstanceOf[ ABlock ]
			val unlocalizedName: String = concreteBlock.getUnlocalizedName

			GameRegistry.registerBlock(concreteBlock, unlocalizedName)
			this.log.debug("Registered block with %s, %s", block, unlocalizedName)
		}
		this.log.info("Finished registering Blocks and BlockContainer.")
	}
}
