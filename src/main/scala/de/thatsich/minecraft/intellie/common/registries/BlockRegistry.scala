package de.thatsich.minecraft.intellie.common.registries

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.intellie.common.module.block.ABlock

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class BlockRegistry
{
	def register()
	{
		for( block <- this.blocks )
		{
			val concreteBlock: ABlock = block.asInstanceOf[ ABlock ]
			val unlocalizedName: String = concreteBlock.getUnlocalizedName

			GameRegistry.registerBlock(concreteBlock, unlocalizedName)
			this.log.debug("Registered block with %s, %s", block, unlocalizedName)
		}
		this.log.info("Finished registering Blocks and BlockContainer.")
	}
}
