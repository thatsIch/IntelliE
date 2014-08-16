package de.thatsich.minecraft.intellie.applied.aerodynamics.common.item


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import de.thatsich.minecraft.common.module.util.{CappedValue, NBTAccess}
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound


/**
 * Trait for AE2 Power Storage handling
 *
 * @author thatsIch
 * @since 17.04.2014.
 */
private[item] trait TPowerStorage extends IAEItemPowerStorage
                                          with NBTAccess
                                          with CappedValue
{
	self: AAEPoweredItemArmor =>
	//	def maxStorage: Double

	private final val internalCurrentPower = "internalCurrentPower"
	private final val internalCurrentMaxPower = "internalCurrentMaxPower"
	private final val inject = 80000

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
		val currentStorage = tag.getDouble(internalCurrentPower)

		currentStorage
	}

	def setAECurrentPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(internalCurrentPower, value)
	}

	def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val maxStorage = this.getAEMaxPower(is)
		val newStorage = Math.min(maxStorage, currentStorage + this.inject)
		val diff = maxStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	def getAEMaxPower(is: ItemStack): Double = this.maxStorage

	def setAEMaxPower(is: ItemStack, value: Double): Unit =
	{
		val tag: NBTTagCompound = this.getNBTData(is)
		tag.setDouble(this.internalCurrentMaxPower, value)
	}

	def addAEMaxPower(is: ItemStack, amt: Double): Double =
	{
		val max: Double = this.getAEMaxPower(is)
		this.setAEMaxPower(is, max + amt)

		max + amt
	}
}
