package de.thatsich.minecraft.common.util.nbt


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class BaseBoundNBTProperty[T](_min: T, _max: T, val scale: T = 1)(implicit numeric: Numeric[T])
extends BoundNBTProperty[T]
{
	val min: T = numeric.times(this._min, this.scale)

	val max: T = numeric.times(this._max, this.scale)
}