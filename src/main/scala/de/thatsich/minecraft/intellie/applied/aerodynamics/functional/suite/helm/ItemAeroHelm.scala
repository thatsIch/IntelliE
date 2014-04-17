package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.helm

import net.minecraft.item.ItemStack
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.renderer.texture.IIconRegister
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.module.item.AAEPoweredItemArmor

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class ItemAeroHelm(implicit creativeTab: CreativeTabs)
	extends AAEPoweredItemArmor(50000000, 0)
{


	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/aero.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("appaero:aerohelm")
	}
}
