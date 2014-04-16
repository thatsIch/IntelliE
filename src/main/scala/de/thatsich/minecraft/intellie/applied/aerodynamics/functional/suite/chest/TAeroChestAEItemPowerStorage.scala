package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import cpw.mods.fml.common.Optional
import de.thatsich.minecraft.core.OModIDs
import net.minecraft.item.ItemStack
import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage

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

	@Optional.Method(modid = OModIDs.AE2)
	def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	@Optional.Method(modid = OModIDs.AE2)
	def getAECurrentPower(is: ItemStack): Double = this.currentPower

	@Optional.Method(modid = OModIDs.AE2)
	def getAEMaxPower(is: ItemStack): Double = ItemAeroChest.ENERGY_MAX

	@Optional.Method(modid = OModIDs.AE2)
	def extractAEPower(is: ItemStack, amt: Double): Double = ItemAeroChest.TRANSFER

	@Optional.Method(modid = OModIDs.AE2)
	def injectAEPower(is: ItemStack, amt: Double): Double = 0.0
}
