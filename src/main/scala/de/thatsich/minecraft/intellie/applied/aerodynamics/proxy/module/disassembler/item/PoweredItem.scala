package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import de.thatsich.minecraft.common.module.BaseItem
import de.thatsich.minecraft.common.module.util.NBTAccess
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
private[disassembler] trait PoweredItem extends BaseItem
                                                with IAEItemPowerStorage
                                                with NBTAccess
                                                with DisassemblerConfigAccess
{
	def injectAEPower(is: ItemStack, amt: Double): Double =
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

	// AE Charge Multiplier
	def getCurrentChargeMultiplier(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val value = tag.getDouble(Tags.ChargeSpeed)

		(this.initChargeMultiplier + value) min this.maxChargeMultiplier
	}

	def addAEMaxPower(is: ItemStack, amt: Double): Double =
	{
		val max: Double = this.getAEMaxPower(is)
		val sum = max + amt
		this.setAEMaxPower(is, sum)

		sum
	}

	// AE Max Power
	def getAEMaxPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current = tag.getDouble(Tags.MaxEnergy)

		(this.initEnergy + current) min this.maxEnergy
	}

	def setAEMaxPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.MaxEnergy, value)
	}

	def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val newStorage = Math.max(0.0, currentStorage - amt)
		val diff = currentStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	// AE Current Power
	def getAECurrentPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		tag.getDouble(Tags.CurrentEnergy)
	}

	def setAECurrentPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.CurrentEnergy, value)
	}

	def addAECurrentPower(is: ItemStack, value: Double): Double =
	{
		val currentPower: Double = this.getAECurrentPower(is)
		val sum: Double = currentPower + value
		this.setAECurrentPower(is, sum)

		sum
	}

	def setCurrentChargeMultiplier(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.ChargeSpeed, value)
	}

	// AE Current Energy Usage
	def getCurrentEnergyUsage(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val value = tag.getDouble(Tags.EnergyCost)

		(this.initEnergyUsage - value) max this.minEnergyUsage
	}

	def setCurrentEnergyPerBlockBreak(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.EnergyCost, value)
	}

	private object Tags extends BaseNBTProperty
	{
		val CurrentEnergy, MaxEnergy, ChargeSpeed, EnergyCost = Value
	}
	this.addNBTs(Tags)

}
