package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import net.minecraft.item.{ItemStack, Item}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait SpecialTool extends Item
{
	override def isRepairable: Boolean = false

	override def isDamageable: Boolean = true

	override def isDamaged(stack: ItemStack): Boolean = true

	override def showDurabilityBar(stack: ItemStack): Boolean = true

	override def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false

}
