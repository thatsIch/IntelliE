package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import de.thatsich.minecraft.common.module.util.NBTAccess
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
trait HorseShoesItemPowerStorage extends IAEItemPowerStorage
                                         with NBTAccess
                                         with NBTKeyStorage
                                         with HorseShoesConfigAccess
{
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

	// AE Charge Multiplier
	def getCurrentChargeMultiplier(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val value = tag.getDouble(Tags.ChargeMultiplier)

		(this.initChargeMultiplier + value) min this.maxChargeMultiplier
	}

	override def getAEMaxPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current = tag.getDouble(Tags.MaxEnergy)

		(this.initEnergy max current) min this.maxEnergy
	}

	override def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	override def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val newStorage = Math.max(0.0, currentStorage - amt)
		val diff = currentStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	override def getAECurrentPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		tag.getDouble(Tags.CurrentEnergy)
	}

	def setAECurrentPower(is: ItemStack, value: Double): Unit =
	{
		val tag = this.getNBTData(is)
		tag.setDouble(Tags.CurrentEnergy, value)
	}

	def getDischargePerTick(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val current = tag.getDouble(Tags.DischargePerTick)

		(this.minDischargePerTick max current) min this.initDischargePerTick
	}

	def setDischargePerTick(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(Tags.DischargePerTick, value)

	private object Tags extends BaseNBTProperty
	{
		val CurrentEnergy, MaxEnergy, ChargeMultiplier, DischargePerTick = Value
	}

	this.addNBTs(Tags)
}
