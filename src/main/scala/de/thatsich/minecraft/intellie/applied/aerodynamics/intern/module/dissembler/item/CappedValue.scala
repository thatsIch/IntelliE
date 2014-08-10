package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait CappedValue
{
	protected def getInBetween(min: Double, value: Double, max: Double): Double =
	{
		min.max(max.min(value))
	}

	protected def getInBetween(min: Int, value: Int, max: Int): Int =
	{
		min.max(max.min(value))
	}
}
