package de.thatsich.minecraft.core

/**
 *
 *
 * @author thatsIch
 * @since 09.04.2014.
 */
abstract class AStringWrapper(val value: String)
{

}

object AStringWrapper
{
	implicit def wrapperToString(wrapper: AStringWrapper): String =
	{
		wrapper.value
	}
}
