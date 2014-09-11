package de.thatsich.minecraft.common.util.string


import scala.language.implicitConversions


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
