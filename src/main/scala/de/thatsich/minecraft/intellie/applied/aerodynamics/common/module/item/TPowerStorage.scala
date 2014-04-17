package de.thatsich.minecraft.intellie.applied.aerodynamics.common.module.item

import appeng.api.implementations.items.IAEItemPowerStorage
import cpw.mods.fml.common.Optional
import de.thatsich.minecraft.core.OModIDs
import net.minecraft.item.ItemStack
import appeng.api.config.AccessRestriction
import net.minecraft.nbt.NBTTagCompound

/**
 * Trait for AE2 Power Storage handling
 *
 * @author thatsIch
 * @since 17.04.2014.
 */
@Optional.Interface(iface = "appeng.api.implementations.items.IAEItemPowerStorage", modid = OModIDs.AE2, striprefs = true)
private[ item ] trait TPowerStorage extends IAEItemPowerStorage
{
	self: AAEPoweredItemArmor =>

	private final val internalCurrentPower = "internalCurrentPower"
	private final val inject               = 80000

	@Optional.Method(modid = OModIDs.AE2)
	def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	@Optional.Method(modid = OModIDs.AE2)
	def getAECurrentPower(is: ItemStack): Double =
	{
		val tag = this.getNBTData(is)
		val currentStorage = tag.getDouble(internalCurrentPower)

		currentStorage
	}

	@Optional.Method(modid = OModIDs.AE2)
	def setAECurrentPower(is: ItemStack, value: Double)
	{
		val tag = this.getNBTData(is)
		tag.setDouble(internalCurrentPower, value)
	}

	@Optional.Method(modid = OModIDs.AE2)
	def getAEMaxPower(is: ItemStack): Double = this.maxStorage

	@Optional.Method(modid = OModIDs.AE2)
	def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val newStorage = Math.max(0.0, currentStorage - amt)
		this.setAECurrentPower(is, newStorage)

		newStorage
	}

	@Optional.Method(modid = OModIDs.AE2)
	def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		val currentStorage = this.getAECurrentPower(is)
		val maxStorage = this.getAEMaxPower(is)
		val newStorage = Math.min(maxStorage, currentStorage + this.inject)
		val diff = maxStorage - newStorage
		this.setAECurrentPower(is, newStorage)

		diff
	}

	private def getNBTData(itemStack: ItemStack): NBTTagCompound =
	{
		var compound = itemStack.getTagCompound
		if( compound == null )
		{
			compound = new NBTTagCompound
			itemStack.setTagCompound(compound)
		}

		compound
	}
}
