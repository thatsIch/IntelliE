package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.HorseShoesConfigAccess


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
object PowerStorageTags extends NBTTags with HorseShoesConfigAccess
{
	object CurrentEnergy extends BaseBoundNBTProperty(this.initEnergy, this.maxEnergy)
	object MaxEnergy extends BaseBoundNBTProperty(this.initEnergy, this.maxEnergy)
	object ChargeMultiplier extends BaseBoundNBTProperty(this.initChargeMultiplier, this.maxChargeMultiplier)
	object DischargePerTick extends BaseBoundNBTProperty(this.minDischargePerTick, this.initDischargePerTick)

	override def values: Seq[BoundNBTProperty] = Vector(CurrentEnergy, MaxEnergy, ChargeMultiplier, DischargePerTick)
}
