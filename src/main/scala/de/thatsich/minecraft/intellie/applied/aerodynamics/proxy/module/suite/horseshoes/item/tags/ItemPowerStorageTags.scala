package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config.HorseShoesItemPowerStorageConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class ItemPowerStorageTags(config: HorseShoesItemPowerStorageConfig) extends NBTTags
{
	object CurrentEnergy extends BaseBoundNBTProperty(this.config.minimalEnergy, this.config.maximalEnergy)
	object MaxEnergy extends BaseBoundNBTProperty(this.config.minimalEnergy, this.config.maximalEnergy)
	object ChargeMultiplier extends BaseBoundNBTProperty(this.config.minimalChargeMultiplier, this.config.maximalChargeMultiplier)
	object DischargePerTick extends BaseBoundNBTProperty(this.config.minimalDischargePerTick, this.config.maximalDischargePerTick)

	override def values: Seq[BoundNBTProperty] = Vector(CurrentEnergy, MaxEnergy, ChargeMultiplier, DischargePerTick)
}
