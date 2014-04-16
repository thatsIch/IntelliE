package de.thatsich.minecraft.intellie.applied.aerodynamics.common

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{ItemArmor, Item}
import de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest.ItemAeroChest
import cpw.mods.fml.relauncher.Side
import net.minecraft.client.renderer.texture.IIconRegister

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class AeroCreativeTabs
	extends CreativeTabs("appliedAerodynamicsTab")
{
	private def getIcon(implicit icon: ItemAeroChest): Item =
	{
		icon
	}

	override def getTabIconItem: Item =
	{
		this.getIcon
	}
}
