package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item.config.ArmorPowerConfig


/**
 * 
 *
 * @author thatsIch
 * @since 17.09.2014.
 */
class ArmorPowerTags(config: ArmorPowerConfig) extends NBTTags
{
	override def values = Vector(CurrentEnergy, MaxEnergy, ChargeMultiplier, DischargePerTick)

	object CurrentEnergy extends BaseBoundNBTProperty[Double](this.config.minimalEnergy, this.config.maximalEnergy)

	object MaxEnergy extends BaseBoundNBTProperty[Double](this.config.minimalEnergy, this.config.maximalEnergy)

	object ChargeMultiplier extends BaseBoundNBTProperty[Int](this.config.minimalChargeMultiplier, this.config.maximalChargeMultiplier)

	object DischargePerTick extends BaseBoundNBTProperty[Double](this.config.minimalDischargePerTick, this.config.maximalDischargePerTick)

}
