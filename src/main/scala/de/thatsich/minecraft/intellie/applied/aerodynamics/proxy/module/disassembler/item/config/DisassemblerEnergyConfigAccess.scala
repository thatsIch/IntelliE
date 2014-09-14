package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
class DisassemblerEnergyConfigAccess(config: Config) extends DisassemblerEnergyConfig
{
	override def minimalEnergy: Double = this.config.getDouble("Energy", "minimalEnergy", 0)

	override def minimalEnergyPerBlockBreak: Double = this.config.getDouble("Energy", "minimalEnergyPerBlockBreak", 6666)

	override def maximalEnergyPerBlockBreak: Double = this.config.getDouble("Energy", "maximalEnergyPerBlockBreak", 100000)

	override def minimalChargeMultiplier: Int = this.config.getInt("Energy", "minimalChargeMultiplier", 1)

	override def maximalEnergy: Double = this.config.getDouble("Energy", "maximalEnergy", 100000000)

	override def maximalChargeMultiplier: Int = this.config.getInt("Energy", "maximalChargeMultiplier", 10000)
}
