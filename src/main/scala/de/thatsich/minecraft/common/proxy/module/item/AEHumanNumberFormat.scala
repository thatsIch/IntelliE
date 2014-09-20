package de.thatsich.minecraft.common.proxy.module.item


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait AEHumanNumberFormat
{
	protected def readableForm(value: Int): String =
	{
		val unit = 1000
		if (value < unit) return value + " AE"
		val exp = (Math.log(value) / Math.log(unit)).toInt
		val pre: String = "kMBT".charAt(exp - 1) + ""

		f"${value / Math.pow(unit, exp)}%.1f ${pre}AE"
	}
}
