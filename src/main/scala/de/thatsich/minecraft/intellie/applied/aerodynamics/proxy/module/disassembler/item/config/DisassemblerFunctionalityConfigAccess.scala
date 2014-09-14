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
	override def minimalMiningSpeed: Int = this.config.getInt("Functionality", "minimalMiningSpeed", 1)

	override def maximalMiningSpeed: Int = this.config.getInt("Functionality", "maximalMiningSpeed", 5000)

	override def maximalMiningLevel: Int = this.config.getInt("Functionality", "maximalMiningLevel", 0)

	override def minimalMiningLevel: Int = this.config.getInt("Functionality", "minimalMiningLevel", 5)
}
