package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class AeroCreativeTabs( icon: Item ) extends CreativeTabs( "appliedAerodynamicsTab" )
{
	override def getTabIconItem: Item =
	{
		this.icon
	}
}
