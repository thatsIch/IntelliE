package de.thatsich.minecraft.intellie.applied.aerodynamics


import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.AeroModules


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
