package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.suite.chest.ItemAeroChest
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class AeroCreativeTabs extends CreativeTabs( "appliedAerodynamicsTab" )
{
	private def getIcon( implicit icon: ItemAeroChest ): Item =
	{
		icon
	}

	override def getTabIconItem: Item =
	{
		this.getIcon
	}
}
