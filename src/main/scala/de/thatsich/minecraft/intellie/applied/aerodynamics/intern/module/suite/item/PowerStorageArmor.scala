package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
trait PowerStorageArmor extends IAEItemPowerStorage
{
	def injectAEPower(is: ItemStack, amt: Double): Double = 0

	def getAECurrentPower(is: ItemStack): Double = 0

	def getPowerFlow(is: ItemStack): AccessRestriction = AccessRestriction.WRITE

	def getAEMaxPower(is: ItemStack): Double = 0

	def extractAEPower(is: ItemStack, amt: Double): Double = 0
}
