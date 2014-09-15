package de.thatsich.minecraft.intellie.applied.aerodynamics


import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.{AeroModules, NBTItemRegistry}


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait AeroProxy
{
	def nbtitemregistry: NBTItemRegistry

	def modules: AeroModules
}
