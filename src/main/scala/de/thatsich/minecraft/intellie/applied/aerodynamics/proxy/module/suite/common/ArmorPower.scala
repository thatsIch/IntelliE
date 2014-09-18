package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import de.thatsich.minecraft.common.proxy.module.util.NBTAccess
import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.tags.ArmorPowerTags
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 17.09.2014.
 */
trait ArmorPower
extends IAEItemPowerStorage
        with NBTAccess
        with BoundDetection
{
	def powerTags: ArmorPowerTags

	override def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val maxStorage = this.getAEMaxPower(is)
		val multiplier = this.getCurrentChargeMultiplier(is)

		val newStorage = currentStorage + amt * multiplier
		val cappedStorage = Math.min(maxStorage, newStorage)
		val diff = cappedStorage - currentStorage

		this.setAECurrentPower(is, cappedStorage)

		amt - diff
	}

	override def getAEMaxPower(is: ItemStack): Double = this.withinBounds(is, this.powerTags.MaxEnergy)

	override def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	override def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val newStorage = Math.max(0.0, currentStorage - amt)
		val diff = currentStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	override def getAECurrentPower(is: ItemStack): Double = this.withinBounds(is, this.powerTags.CurrentEnergy)

	def getCurrentChargeMultiplier(is: ItemStack): Int = this.withinBounds(is, this.powerTags.ChargeMultiplier)

	def setAECurrentPower(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(this.powerTags.CurrentEnergy.toString, value)

	def getDischargePerTick(is: ItemStack): Double = this.withinReversedBounds(is, this.powerTags.DischargePerTick)
}
