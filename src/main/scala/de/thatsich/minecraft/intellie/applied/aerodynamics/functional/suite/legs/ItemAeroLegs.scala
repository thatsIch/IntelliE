package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.legs

import net.minecraft.item.{ItemStack, ItemArmor}
import net.minecraft.creativetab.CreativeTabs
import de.thatsich.minecraft.core.module.item.AItemArmor
import net.minecraft.entity.Entity
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.renderer.texture.IIconRegister

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class ItemAeroLegs(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
                  (implicit creativeTab: CreativeTabs)
	extends AItemArmor(material, renderIndex, armorType)
{
	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/aero.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("appaero:aerolegs")
	}
}
