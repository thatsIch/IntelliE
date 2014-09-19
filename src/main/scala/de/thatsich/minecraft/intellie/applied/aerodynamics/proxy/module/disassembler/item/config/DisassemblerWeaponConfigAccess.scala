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
	override val minimalDamageVsEntites: Double = this.config.getDouble("Combat", "initialDamageVsEntites", 0)

	override val maximalDamageVsEntites: Double = this.config.getDouble("Combat", "maximalDamageVsEntites", 20)

	this.config.save()
}
