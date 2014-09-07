package de.thatsich.minecraft.intellie.applied.aerodynamics


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.string.Abbreviation
import de.thatsich.minecraft.common.string.id.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.Modules


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait Proxy
{
	def mod: AnyRef

	def modid: ID

	def abbr: Abbreviation

	def log: Log

	def modules: Modules
}
