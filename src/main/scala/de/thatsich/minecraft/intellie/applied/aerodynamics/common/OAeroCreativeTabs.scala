package de.thatsich.minecraft.intellie.applied.aerodynamics.common

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.init.Items

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
object OAeroCreativeTabs extends CreativeTabs("appliedAerodynamicsTab")
{
	override def getTabIconItem: Item =
	{
		Items.spider_eye
	}
}
