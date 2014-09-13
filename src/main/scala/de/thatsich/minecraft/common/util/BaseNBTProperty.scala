package de.thatsich.minecraft.common.util


import scala.language.implicitConversions


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class BaseNBTProperty extends Enumeration
{
	implicit def valuesToString(value: Value): String = value.toString.toLowerCase
}
