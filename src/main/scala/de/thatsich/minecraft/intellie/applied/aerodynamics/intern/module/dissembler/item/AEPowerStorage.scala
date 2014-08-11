package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import de.thatsich.minecraft.common.module.util.{CappedValue, NBTAccess}
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
private[dissembler] trait AEPowerStorage extends IAEItemPowerStorage
                                                 with NBTAccess
                                                 with DissemblerConfigAccess
                                                 with CappedValue
{
	def addAEMaxPower(is: ItemStack, amt: Double): Double =
	{
		val max: Double = this.getAEMaxPower(is)
		val sum = max + amt
		this.setAEMaxPower(is, sum)

		sum
	}

	def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val maxStorage = this.getAEMaxPower(is)

		val newStorage = Math.min(maxStorage, currentStorage + amt * this.getCurrentChargeMultiplier(is))
		val diff = maxStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	def getAEMaxPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current = tag.getDouble(Tags.CurrentMaxPower)

		this.getInBetween(this.initEnergy, current, this.maxEnergy)
	}

	def setAEMaxPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.CurrentMaxPower, value)
	}

	def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val newStorage = Math.max(0.0, currentStorage - amt)
		this.setAECurrentPower(is, newStorage)

		newStorage
	}

	def getAECurrentPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		tag.getDouble(Tags.CurrentPower)
	}

	def setAECurrentPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.CurrentPower, value)
	}

	def getCurrentChargeMultiplier(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val value = tag.getDouble(Tags.CurrentChargeMultiplier)

		(this.initChargeMultiplier max value) min this.maxChargeMultiplier
	}

	def setCurrentChargePerTick(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.CurrentChargeMultiplier, value)
	}

	def getCurrentEnergyPerBlockBreak(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val value = tag.getDouble(Tags.CurrentEnergyUsage)

		(this.initEnergyUsage min value) max this.minEnergyUsage
	}

	def setCurrentEnergyPerBlockBreak(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.CurrentEnergyUsage, value)
	}

	private object Tags extends Enumeration
	{
		type Tags = Value
		val CurrentPower, CurrentMaxPower, CurrentChargeMultiplier, CurrentEnergyUsage = Value

		implicit def tagsToString(tag: Tags): String = tag.toString
	}

}
