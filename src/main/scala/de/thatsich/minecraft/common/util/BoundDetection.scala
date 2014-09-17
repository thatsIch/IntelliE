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
	def withinBounds[Double](stack: ItemStack, prop: BoundNBTProperty[scala.Double]): scala.Double =
	{
		val tag = this.getNBTData(stack)
		val current: scala.Double = tag.getDouble(prop.toString)
		val min: scala.Double = prop.min * prop.scale
		val max: scala.Double = prop.max * prop.scale

		(current max min) min max
	}

	def withinBounds[Float](stack: ItemStack, prop: BoundNBTProperty[scala.Float]): scala.Float =
	{
		val tag = this.getNBTData(stack)
		val current: scala.Float = tag.getFloat(prop.toString)
		val min: scala.Float = prop.min * prop.scale
		val max: scala.Float = prop.max * prop.scale

		(current max min) min max
	}

	def withinBounds[Int](stack: ItemStack, prop: BoundNBTProperty[scala.Int]): scala.Int =
	{
		val tag = this.getNBTData(stack)
		val current: scala.Int = tag.getInteger(prop.toString)
		val min: scala.Int = prop.min * prop.scale
		val max: scala.Int = prop.max * prop.scale

		(current max min) min max
	}

	def withinReversedBounds[Double](stack: ItemStack, prop: BoundNBTProperty[scala.Double]): scala.Double =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getDouble(prop.toString)
		val min: scala.Double = prop.min * prop.scale
		val max: scala.Double = prop.max * prop.scale

		if (current == 0) max else current max min
	}

	def withinReversedBounds[Float](stack: ItemStack, prop: BoundNBTProperty[scala.Float]): scala.Float =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getFloat(prop.toString)
		val min = prop.min * prop.scale
		val max = prop.max * prop.scale

		if (current == 0) max else current max min
	}

	def withinReversedBounds[Int](stack: ItemStack, prop: BoundNBTProperty[scala.Int]): scala.Int =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getInteger(prop.toString)
		val min = prop.min * prop.scale
		val max = prop.max * prop.scale

		if (current == 0) max else current max min
	}
}
