package de.thatsich.minecraft.api.mod.module

import de.thatsich.minecraft.api.mod.StringWrapper

/**
 *
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
trait Name extends StringWrapper
{
	val name: String = this.wrapped
}
