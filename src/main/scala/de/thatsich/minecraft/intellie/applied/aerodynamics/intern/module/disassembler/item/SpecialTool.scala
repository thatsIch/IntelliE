package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler.item


import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait SpecialTool extends Item
                          with AEPowerStorage
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
