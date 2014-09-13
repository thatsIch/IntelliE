package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class CreativeHorseShoesItem(val modid: ModID, log: Log) extends HorseShoesItem(modid, log)
{
	override def getUnlocalizedName: String = s"${modid.id}.item.creative_horseshoes"

	override def getEnergyPerDamage(armor: ItemStack): Double = this.minEnergyPerDamagePoint

	override def getAbsorptionRatio(armor: ItemStack): Double = this.maxAbsorptionRatio

	override def getArmorBase(armor: ItemStack): Double = this.maxArmorBase

	override def getCurrentChargeMultiplier(is: ItemStack): Double = this.maxChargeMultiplier

	override def getAECurrentPower(is: ItemStack): Double = this.maxEnergy

	override def getAEMaxPower(is: ItemStack): Double = this.maxEnergy

	override def getDischargePerTick(is: ItemStack): Double = this.minDischargePerTick

	override def getStepHeight(is: ItemStack): Double = this.maxStepHeight
}
