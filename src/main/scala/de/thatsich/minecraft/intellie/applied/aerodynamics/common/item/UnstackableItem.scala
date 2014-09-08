package de.thatsich.minecraft.intellie.applied.aerodynamics.common.item


import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait UnstackableItem extends Item
{
	this.setMaxStackSize(1)
}
