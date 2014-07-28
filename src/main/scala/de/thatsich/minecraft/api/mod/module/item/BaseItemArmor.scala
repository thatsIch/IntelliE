package de.thatsich.minecraft.api.mod.module.item

import net.minecraft.entity.Entity
import net.minecraft.item.{ItemArmor, ItemStack}

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseItemArmor( material: ItemArmor.ArmorMaterial, renderIndex: Int, armorType: Int )
	extends ItemArmor( material, renderIndex, armorType )
{
	this.setUnlocalizedName( this.getClass.getSimpleName )

	override def getArmorTexture( stack: ItemStack, entity: Entity, slot: Int, `type`: String ): String =
	{
		"appaero:textures/suite/armor.png"
	}
}
