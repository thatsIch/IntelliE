package de.thatsich.minecraft.intellie.common.module

/**
 * Basic wrapper for a name
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AName(val name: String)
{}

object AName
{
	implicit def nameToString(name: AName): String = name.name
}