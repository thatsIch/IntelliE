package de.thatsich.minecraft.api.mod.module.registries

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.api.mod.module.Module
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock

/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
trait BlockRegistry
{
	def registerBlocks( modules: Seq[ Module ] ): Unit =
	{
		for( module <- modules )
		{
			module.moduleParts.foreach
			{
				case block: Block => this.registerBlock( block )
				case _ =>
			}
		}
	}

	private def registerBlock( block: Block ): Unit =
	{
		GameRegistry.registerBlock( block, block.getUnlocalizedName )
	}

	private def registerBlock( block: Block, itemBlock: ItemBlock ): Unit =
	{
		GameRegistry.registerBlock( block, itemBlock.getClass, block.getUnlocalizedName )
	}


}
