package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config


import de.thatsich.minecraft.common.config.Config


/**
 * 
 *
 * @author thatsIch
 * @since 14.09.2014.
 */
class DisassemblerItemPowerStorageConfigAccess(config: Config) extends DisassemblerItemPowerStorageConfig
{
	override val minimalEnergy: Double = this.config.getDouble("Energy", "minimalEnergy", 0)

	override val minimalEnergyPerBlockBreak: Double = this.config.getDouble("Energy", "minimalEnergyPerBlockBreak", 6666)

	override val maximalEnergyPerBlockBreak: Double = this.config.getDouble("Energy", "maximalEnergyPerBlockBreak", 100000)

	override val minimalChargeMultiplier: Int = this.config.getInt("Energy", "minimalChargeMultiplier", 1)

	override val maximalEnergy: Double = this.config.getDouble("Energy", "maximalEnergy", 100000000)

	override val maximalChargeMultiplier: Int = this.config.getInt("Energy", "maximalChargeMultiplier", 10000)

	this.config.save()
}
