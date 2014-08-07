package de.thatsich.minecraft.common.module.registries

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.module.Module
import net.minecraft.block.Block

/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class BlockRegistry extends CamelCaseParser
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
		GameRegistry.registerBlock( block, this.getBlockName( block ) )
	}

	//	private def registerBlock( block: Block, itemBlock: ItemBlock ): Unit =
	//	{
	//		GameRegistry.registerBlock( block, itemBlock.getClass,  this.getBlockName( block ) )
	//	}

	private def getBlockName( block: Block ): String =
	{
		val className: String = block.getClass.getSimpleName

		this.parseCamelCase( className )
	}
}
