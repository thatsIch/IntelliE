package de.thatsich.minecraft.common.util

/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
trait BoundDetection
{
	def withinBounds(value: Double, bounds: Double*): Double =
	{
		val max = bounds.max
		val min = bounds.min

		(value max min) min max
	}
}
