package de.thatsich.minecraft.core.module.item

import de.thatsich.minecraft.core.module.ATexture
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class AItem( itemTexture: ATexture )
	extends Item
{
	override def registerIcons( iconRegister: IIconRegister ): Unit =
	{
		val texture: String = this.itemTexture.toString
		this.itemIcon = iconRegister.registerIcon( texture )
	}
}
