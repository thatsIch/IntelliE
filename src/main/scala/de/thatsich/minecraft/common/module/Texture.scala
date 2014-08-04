package de.thatsich.minecraft.common.module

import de.thatsich.minecraft.common.string.StringWrapper

/**
 *
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
trait Texture extends StringWrapper
{
	val texture: String = this.wrapped
}
