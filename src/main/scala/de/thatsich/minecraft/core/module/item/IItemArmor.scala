package de.thatsich.minecraft.core.module.item

import net.minecraft.item.{ItemArmor, ItemStack, Item}

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
trait IItemArmor extends IItem
{
	/**
	Return the armor material for this armor item.
	  */
	def getArmorMaterial: ItemArmor.ArmorMaterial

	/**
	Return whether the specified armor ItemStack has a color.
	  */
	def hasColor(par1ItemStack: ItemStack): Boolean

	/**
	Return the color for the specified armor ItemStack.
	  */
	def getColor(par1ItemStack: ItemStack): Int

	/**
	Remove the color from the specified armor ItemStack.
	  */
	def removeColor(par1ItemStack: ItemStack)

	def func_82813_b(par1ItemStack: ItemStack, par2: Int)

	@Override def setContainerItem(par1Item: Item): Item
}
