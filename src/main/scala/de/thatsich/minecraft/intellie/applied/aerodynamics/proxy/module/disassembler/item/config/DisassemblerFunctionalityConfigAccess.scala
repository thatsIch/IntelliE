package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
class DisassemblerFunctionalityConfigAccess(config: Config) extends DisassemblerFunctionalityConfig
{
	val minimalMiningSpeed: Int = this.config.getInt("Functionality", "minimalMiningSpeed", 1)
	val maximalMiningSpeed: Int = this.config.getInt("Functionality", "maximalMiningSpeed", 5000)
	val maximalMiningLevel: Int = this.config.getInt("Functionality", "maximalMiningLevel", 5)
	val minimalMiningLevel: Int = this.config.getInt("Functionality", "minimalMiningLevel", 0)

	this.config.save()
}
