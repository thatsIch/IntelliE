package de.thatsich.minecraft.intellie.applied.aerodynamics


import de.thatsich.minecraft.intellie.common.util.string.{Abbreviation, ID}


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait AeroProxy
{
	def modid: ID

	def abbr: Abbreviation

	def modules: AeroModules
}
