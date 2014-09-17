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
		val current = tag.getDouble(prop.toString)

		((current + prop.min) min prop.max) / prop.scale
	}

	def withinBounds[Float](stack: ItemStack, prop: BoundNBTProperty[scala.Float]): scala.Float =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getFloat(prop.toString)

		((current + prop.min) min prop.max) / prop.scale
	}

	def withinBounds[Int](stack: ItemStack, prop: BoundNBTProperty[scala.Int]): scala.Int =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getInteger(prop.toString)

		((current + prop.min) min prop.max) / prop.scale
	}

	def withinReversedBounds[Double](stack: ItemStack, prop: BoundNBTProperty[scala.Double]): scala.Double =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getDouble(prop.toString)

		((prop.max - current) max prop.min) / prop.scale
	}

	def withinReversedBounds[Float](stack: ItemStack, prop: BoundNBTProperty[scala.Float]): scala.Float =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getFloat(prop.toString)

		((prop.max - current) max prop.min) / prop.scale
	}

	def withinReversedBounds[Int](stack: ItemStack, prop: BoundNBTProperty[scala.Int]): scala.Int =
	{
		val tag = this.getNBTData(stack)
		val current = tag.getInteger(prop.toString)

		((prop.max - current) max prop.min) / prop.scale
	}
}
