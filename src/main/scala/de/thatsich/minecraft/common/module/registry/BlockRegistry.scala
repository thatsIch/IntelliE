package de.thatsich.minecraft
package common
package module
package registry


import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.common.log.Log
import net.minecraft.block.Block


/**
 * Registry for blocks
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class BlockRegistry(registrable: Modules, log: Log) extends CamelCaseParser with Registry
{
	/**
	 * Registers all the block in modules
	 */
	def registerAll(): Unit =
	{
		for (module: Module <- this.registrable; block <- module.blocks)
		{
			this.register(block)
		}
	}

	/**
	 * Registers a single block
	 *
	 * @param block to be registered block
	 */
	private def register(block: Block): Unit =
	{
		GameRegistry.registerBlock(block, this.getBlockName(block))
	}

	/**
	 * Strips block down to simpler name without block
	 *
	 * @param block block with name
	 *
	 * @return stripped down name of block
	 */
	private def getBlockName(block: Block): String =
	{
		val className: String = block.getClass.getSimpleName

		this.parseCamelCase(className)
	}
}
