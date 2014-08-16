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
class BlockRegistry(registrable: Seq[Module], log: Log)
{
	/**
	 * Registers all the block in modules
	 */
	def registerAll(): Unit =
	{
		var length = 0

		for (module: Module <- this.registrable; block: Block <- module.blocks)
		{
			this.register(block)
			length += 1
		}

		this.log.info(s"Finished loading $length block(s).")
	}

	/**
	 * Registers a single block
	 *
	 * @param block to be registered block
	 */
	private def register(block: Block): Unit =
	{
		val name: String = this.getBlockName(block)
		val simpleClassName: String = block.getClass.getSimpleName

		this.log.debug(s"Adding block $simpleClassName with name $name")
		GameRegistry.registerBlock(block, name)
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
		val unlocalizedName: String = block.getUnlocalizedName
		val position: Int = unlocalizedName.lastIndexOf('.') + 1
		val name: String = unlocalizedName.substring(position)

		name
	}
}
