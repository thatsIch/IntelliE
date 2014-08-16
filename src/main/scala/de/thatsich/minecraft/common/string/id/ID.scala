package de.thatsich.minecraft.common.string.id


import de.thatsich.minecraft.common.string.StringWrapper


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
