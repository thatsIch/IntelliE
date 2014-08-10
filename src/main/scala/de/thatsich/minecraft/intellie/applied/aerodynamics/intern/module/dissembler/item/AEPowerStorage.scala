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
	private final val internalCurrentPower = "internalCurrentPower"
	private final val internalCurrentMaxPower = "internalCurrentMaxPower"
	private final val internalCurrentChargePerTick = "internalCurrentChargePerTick"
	private final val internalCurrentEnergyPerBlockBreak = "internalCurrentEnergyPerBlockBreak"

	def addAEMaxPower(is: ItemStack, amt: Double): Double =
	{
		val max: Double = this.getAEMaxPower(is)
		this.setAEMaxPower(is, max + amt)

		max + amt
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
		val current = tag.getDouble(this.internalCurrentMaxPower)

		this.getInBetween(this.initEnergy, current, this.maxEnergy)
	}

	def setAEMaxPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(this.internalCurrentMaxPower, value)
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
		tag.getDouble(this.internalCurrentPower)
	}

	def setAECurrentPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(this.internalCurrentPower, value)
	}

	def getCurrentChargeMultiplier(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current: Double = tag.getDouble(this.internalCurrentChargePerTick)

		this.getInBetween(this.initChargeMultiplier, current, this.maxChargeMultiplier)
	}

	def setCurrentChargePerTick(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(this.internalCurrentChargePerTick, value)
	}

	def getCurrentEnergyPerBlockBreak(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current = tag.getDouble(this.internalCurrentEnergyPerBlockBreak)

		this.getInBetween(this.minEnergyPerBlockBreak, current, this.initEnergyPerBlockBreak)
	}

	def setCurrentEnergyPerBlockBreak(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(this.internalCurrentEnergyPerBlockBreak, value)
	}
}
