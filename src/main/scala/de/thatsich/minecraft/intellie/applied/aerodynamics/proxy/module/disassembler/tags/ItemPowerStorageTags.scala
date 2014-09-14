package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.config.DisassemblerItemPowerStorageConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class ItemPowerStorageTags(config: DisassemblerItemPowerStorageConfig) extends NBTTags
{
	override def values: Seq[BoundNBTProperty] = Vector(CurrentEnergy, MaxEnergy, ChargeMultiplier, EnergyCost)

	object CurrentEnergy extends BaseBoundNBTProperty(this.config.minimalEnergy, this.config.maximalEnergy)

	object MaxEnergy extends BaseBoundNBTProperty(this.config.minimalEnergy, this.config.maximalEnergy)

	object ChargeMultiplier extends BaseBoundNBTProperty(this.config.minimalChargeMultiplier, this.config.maximalChargeMultiplier)

	object EnergyCost extends BaseBoundNBTProperty(this.config.minimalEnergyPerBlockBreak, this.config.maximalEnergyPerBlockBreak)

}