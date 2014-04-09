package de.thatsich.minecraft.core.module.item

import net.minecraft.item.Item
import de.thatsich.minecraft.core.module.ATexture
import net.minecraft.client.renderer.texture.IIconRegister

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AItem(itemTexture: ATexture)
	extends Item
	with IItem
{
	override def registerIcons(iconRegister: IIconRegister)
	{
		val texture: String = this.itemTexture.toString
		this.itemIcon = iconRegister.registerIcon(texture)
	}
}
