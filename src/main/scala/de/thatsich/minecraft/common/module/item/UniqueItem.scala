package de.thatsich.minecraft.common.module.item


import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait UniqueItem extends Item
{
	this.setHasSubtypes(false)
}
