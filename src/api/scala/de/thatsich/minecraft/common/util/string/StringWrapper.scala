package de.thatsich.minecraft.intellie.common.util.string


/**
 *
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
trait StringWrapper
{
	protected val wrapped: String
}

object StringWrapper
{
	implicit def wrapperToString(wrapper: StringWrapper): String =
	{
		wrapper.wrapped
	}
}
