package de.thatsich.minecraft.applied.aerodynamics.common

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.init.Items

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
object OAppliedAerodynamicsCreativeTabs extends CreativeTabs("appliedAerodynamicsTab")
{
	override def getTabIconItem: Item =
	{
		Items.spider_eye
	}
}
