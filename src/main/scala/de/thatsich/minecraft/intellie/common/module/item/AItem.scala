package de.thatsich.minecraft.intellie.common.module.item

import net.minecraft.item.Item
import de.thatsich.minecraft.intellie.common.module.ATexture
import net.minecraft.client.renderer.texture.IIconRegister

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class AItem(texture: ATexture)
	extends Item
	with IItem
{
	override def registerIcons(par1IconRegister: IIconRegister)
	{
		val texture: String = this.itemTexture.getTexture
		this.itemIcon = par1IconRegister.registerIcon(texture)
	}
}
