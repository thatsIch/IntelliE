package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
trait DisassemblerEnergyConfig
{
	def minimalEnergy: Double

	def maximalEnergy: Double

	def minimalChargeMultiplier: Int

	def maximalChargeMultiplier: Int

	def minimalEnergyPerBlockBreak: Double

	def maximalEnergyPerBlockBreak: Double
}
