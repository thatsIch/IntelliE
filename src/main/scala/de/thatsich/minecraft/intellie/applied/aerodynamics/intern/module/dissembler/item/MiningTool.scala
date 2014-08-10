package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import de.thatsich.minecraft.common.module.util.{CappedValue, NBTAccess}
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
	private final val internalCurrentMiningSpeed = "internalCurrentMiningSpeed"
	private final val internalCurrentMiningLevel = "internalCurrentMiningLevel"

	def getCurrentMiningSpeed(is: ItemStack): Int =
	{
		val tag = this.getNBTData(is)
		val current: Int = tag.getInteger(this.internalCurrentMiningSpeed)

		this.getInBetween(this.initMiningSpeed, current, this.maxMiningSpeed)
	}

	def setCurrentMiningSpeed(is: ItemStack, value: Int): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setInteger(this.internalCurrentMiningSpeed, value)
	}

	def getCurrentMiningLevel(is: ItemStack): Int =
	{
		val tag = this.getNBTData(is)
		val current = tag.getInteger(this.internalCurrentMiningLevel)

		this.getInBetween(this.initMiningLevel, current, this.maxMiningLevel)
	}

	def setCurrentMiningLevel(is: ItemStack, value: Int): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setInteger(this.internalCurrentMiningLevel, value)
	}
}
