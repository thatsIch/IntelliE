package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import cpw.mods.fml.common.Optional
import de.thatsich.minecraft.core.OModIDs
import net.minecraft.item.ItemStack
import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.nbt.NBTTagCompound

/**
 *
 *
 * @author thatsIch
 * @since 14.04.2014.
 */
@Optional.Interface(iface = "appeng.api.implementations.items.IAEItemPowerStorage", modid = OModIDs.AE2, striprefs = true)
private[ chest ] trait TAeroChestAEItemPowerStorage extends IAEItemPowerStorage
{
	self: ItemAeroChest =>

	private final val internalCurrentPower = "internalCurrentPower"

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
	def getAEMaxPower(is: ItemStack): Double = ItemAeroChest.ENERGY_MAX

	@Optional.Method(modid = OModIDs.AE2)
	def extractAEPower(is: ItemStack, amt: Double): Double =
	{
		val tag = this.getNBTData(is)
		val currentStorage = tag.getDouble(internalCurrentPower)
		val newStorage = Math.max(0.0, currentStorage - amt)
		tag.setDouble(internalCurrentPower, newStorage)

		newStorage
	}

	@Optional.Method(modid = OModIDs.AE2)
	def injectAEPower(is: ItemStack, amt: Double): Double =
	{
		val tag = this.getNBTData(is)
		val inject = ItemAeroChest.TRANSFER
		val currentStorage = tag.getDouble(internalCurrentPower)
		val maxStorage = this.getAEMaxPower(is)
		val newStorage = Math.min(maxStorage, currentStorage + inject)
		val diff = maxStorage - newStorage
		tag.setDouble(internalCurrentPower, newStorage)

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
