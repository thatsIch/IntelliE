package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
class DisassemblerWeaponConfigAccess(config: Config) extends DisassemblerWeaponConfig
{
	override def minimalDamageVsEntites: Float = this.config.getFloat("Combat", "initialDamageVsEntites", 0)

	override def maximalDamageVsEntites: Float = this.config.getFloat("Combat", "maximalDamageVsEntites", 20)
}
