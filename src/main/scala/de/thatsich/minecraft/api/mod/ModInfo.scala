package de.thatsich.minecraft.api.mod

/**
 * Basic information for the [[cpw.mods.fml.common.Mod]] Annotation
 *
 * @author thatsIch
 * @since 09.07.2014.
 */
trait ModInfo
{
	/**
	 * ID of the mod
	 */
	val id: String

	/**
	 * Name of the mod
	 */
	val name: String

	/**
	 * Version of the mod
	 */
	val version: String

	/**
	 * Dependencies of the mod
	 */
	val dependencies: String

	/**
	 * Abbreviation of the mod
	 */
	val abbreviation: String
}
