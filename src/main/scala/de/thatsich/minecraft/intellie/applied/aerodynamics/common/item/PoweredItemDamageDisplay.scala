package de.thatsich.minecraft.intellie.applied.aerodynamics.common.item


import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
trait PoweredItemDamageDisplay extends Item with IAEItemPowerStorage
{
	override def isRepairable: Boolean = false

	override def isDamageable: Boolean = true

	override def isDamaged(stack: ItemStack): Boolean = true

	override def showDurabilityBar(stack: ItemStack): Boolean = true

	override def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false

	override def getDurabilityForDisplay(stack: ItemStack): Double =
	{
		1 - this.getAECurrentPower(stack) / this.getAEMaxPower(stack)
	}
}
