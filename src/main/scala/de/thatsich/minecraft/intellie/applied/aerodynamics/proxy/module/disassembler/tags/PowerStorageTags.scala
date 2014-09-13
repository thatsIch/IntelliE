package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.DisassemblerConfigAccess


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
object PowerStorageTags extends NBTTags with DisassemblerConfigAccess
{
	override def values: Seq[BoundNBTProperty] = Vector(CurrentEnergy, MaxEnergy, ChargeMultiplier, EnergyCost)

	object CurrentEnergy extends BaseBoundNBTProperty(this.initEnergy, this.maxEnergy)

	object MaxEnergy extends BaseBoundNBTProperty(this.initEnergy, this.maxEnergy)

	object ChargeMultiplier extends BaseBoundNBTProperty(this.initChargeMultiplier, this.maxChargeMultiplier)

	object EnergyCost extends BaseBoundNBTProperty(this.minEnergyUsage, this.initEnergyUsage)

}