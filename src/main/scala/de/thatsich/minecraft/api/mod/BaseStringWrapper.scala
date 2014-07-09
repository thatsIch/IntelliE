package de.thatsich.minecraft.api.mod

/**
 *
 *
 * @author thatsIch
 * @since 09.04.2014.
 */
abstract class BaseStringWrapper( val string: String )
	extends StringWrapper
{

}

object BaseStringWrapper
{
	implicit def wrapperToString( wrapper: BaseStringWrapper ): String =
	{
		wrapper.string
	}
}
