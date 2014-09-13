package de.thatsich.minecraft.common.module.item


import de.thatsich.minecraft.common.util.string.ModID
import net.minecraft.item.Item


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
trait FakeItem extends Item
{
	def modid: ModID

	this.setHarvestLevel("fake", 0)
}
