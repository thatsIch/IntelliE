package de.thatsich.minecraft.common.util.string


import de.thatsich.minecraft.intellie.common.util.string.StringWrapper


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
