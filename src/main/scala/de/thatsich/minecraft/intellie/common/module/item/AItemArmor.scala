package de.thatsich.minecraft.intellie.common.module.item

import net.minecraft.item.{ItemStack, ItemArmor}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AItemArmor(material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int)
	extends ItemArmor(material, renderIndex, armorType)
	with IItemArmor
{
	this.setCreativeTab(CreativeTabs.tabCombat)

	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/suite/armor.png"
	}
}
