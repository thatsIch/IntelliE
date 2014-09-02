package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.item


import appeng.api.config.AccessRestriction
import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
trait HorseShoesItemPowerStorage extends IAEItemPowerStorage
{
	override def injectAEPower(p1: ItemStack, p2: Double): Double = ???

	override def getAECurrentPower(p1: ItemStack): Double = ???

	override def getPowerFlow(p1: ItemStack): AccessRestriction = ???

	override def getAEMaxPower(p1: ItemStack): Double = ???

	override def extractAEPower(p1: ItemStack, p2: Double): Double = ???
}
