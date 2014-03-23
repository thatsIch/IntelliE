package de.thatsich.intellie.common.module.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 @author thatsIch
 @date 21.03.2014. */
public interface IItemArmor extends IItem
{
	/**
	 Return the armor material for this armor item.
	 */
	ItemArmor.ArmorMaterial getArmorMaterial ();

	/**
	 Return whether the specified armor ItemStack has a color.
	 */
	boolean hasColor ( ItemStack par1ItemStack );

	/**
	 Return the color for the specified armor ItemStack.
	 */
	int getColor ( ItemStack par1ItemStack );

	/**
	 Remove the color from the specified armor ItemStack.
	 */
	void removeColor ( ItemStack par1ItemStack );

	void func_82813_b ( ItemStack par1ItemStack, int par2 );

	@Override
	Item setContainerItem ( Item par1Item );
}
