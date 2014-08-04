package de.thatsich.minecraft.common.string

/**
 *
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
trait ID extends StringWrapper
{
	val id: String = this.wrapped
}
