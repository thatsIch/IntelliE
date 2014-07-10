package de.thatsich.minecraft.api.mod.module.item

import de.thatsich.minecraft.api.mod.module.BaseTexture
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class BaseItem( itemTexture: BaseTexture )
	extends Item
{
	override def registerIcons( iconRegister: IIconRegister ): Unit =
	{
		val texture: String = this.itemTexture.toString
		this.itemIcon = iconRegister.registerIcon( texture )
	}
}
