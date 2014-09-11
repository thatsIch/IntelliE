package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


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
		"%.1f %sAE".format(value / Math.pow(unit, exp), pre)
	}
}
