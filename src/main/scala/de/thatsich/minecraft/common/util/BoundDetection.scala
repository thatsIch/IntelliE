package de.thatsich.minecraft.common.util


import de.thatsich.minecraft.common.proxy.module.util.NBTAccess
import de.thatsich.minecraft.common.util.nbt.BoundNBTProperty
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
trait BoundDetection extends NBTAccess
{
	def withinBounds(value: Double, bounds: Double*): Double =
	{
		val max = bounds.max
		val min = bounds.min

		(value max min) min max
	}

	def withinBounds(stack: ItemStack, prop: BoundNBTProperty): Double =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getDouble(prop)
		val min = prop.min
		val max = prop.max

		(current max min) min max
	}

	def withinReversedBounds(stack: ItemStack, prop: BoundNBTProperty): Double =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getDouble(prop)
		val min = prop.min
		val max = prop.max

		if (current == 0) max else current max min
	}
}
