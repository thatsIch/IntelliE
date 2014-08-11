package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import de.thatsich.minecraft.common.module.util.{CappedValue, NBTAccess}
import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait MiningTool extends Item
                         with NBTAccess
                         with DissemblerConfigAccess
                         with CappedValue
{
	/**
	 * gets the mining speed
	 *
	 * @param is ItemStack of this
	 * @param block Mining block
	 * @param metadata metadata of bloc
	 *
	 * @return configured mining speed
	 */
	override def getDigSpeed(is: ItemStack, block: Block, metadata: Int): Float =
	{
		this.getCurrentMiningSpeed(is)
	}

	def getCurrentMiningSpeed(is: ItemStack): Int =
	{
		val tag = this.getNBTData(is)
		val current: Int = tag.getInteger(MiningTool.internalCurrentMiningSpeed)

		this.getInBetween(this.initMiningSpeed, current, this.maxMiningSpeed)
	}

	def setCurrentMiningSpeed(is: ItemStack, value: Int): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setInteger(MiningTool.internalCurrentMiningSpeed, value)
	}

	def getCurrentMiningLevel(is: ItemStack): Int =
	{
		val tag = this.getNBTData(is)
		val current = tag.getInteger(MiningTool.internalCurrentMiningLevel)

		this.getInBetween(this.initMiningLevel, current, this.maxMiningLevel)
	}

	def setCurrentMiningLevel(is: ItemStack, value: Int): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setInteger(MiningTool.internalCurrentMiningLevel, value)
	}
}

private[this] object MiningTool {
	private final val internalCurrentMiningSpeed = "internalCurrentMiningSpeed"
	private final val internalCurrentMiningLevel = "internalCurrentMiningLevel"
}

