package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import de.thatsich.minecraft.common.module.util.NBTAccess
import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags.PowerStorageTags
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags.PowerStorageTags
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
private[disassembler] trait PoweredItem
extends IAEItemPowerStorage
        with NBTAccess
        with NBTKeyStorage
        with BoundDetection
{
	def powerStorageTags: PowerStorageTags

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

	override def getAECurrentPower(is: ItemStack): Double = this.getNBTData(is).getDouble(PowerStorageTags.CurrentEnergy)

	def getCurrentChargeMultiplier(is: ItemStack): Double = this.withinBounds(is, PowerStorageTags.ChargeMultiplier)

	def setAECurrentPower(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(PowerStorageTags.CurrentEnergy, value)

	override def getAEMaxPower(is: ItemStack): Double = this.withinBounds(is, PowerStorageTags.MaxEnergy)

	override def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	override def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val newStorage = Math.max(0.0, currentStorage - amt)
		val diff = currentStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	def setAEMaxPower(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(PowerStorageTags.MaxEnergy, value)

	def setCurrentChargeMultiplier(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(PowerStorageTags.ChargeMultiplier, value)

	def getCurrentEnergyUsage(is: ItemStack): Double = this.withinBounds(is, this.powerStorageTags.EnergyCost)

	def setCurrentEnergyPerBlockBreak(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(this.powerStorageTags.EnergyCost, value)
}
