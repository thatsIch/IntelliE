package de.thatsich.minecraft.intellie.applied.aerodynamics


import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.{AeroModules, NBTKeyRegistry}


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait AeroProxy
{
	def nbtkeyregistry: NBTKeyRegistry

	def modules: AeroModules
}
