package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.helm


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.common.item.AAEPoweredItemArmor
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
object AeroHelmItem extends AeroHelmItem

class AeroHelmItem extends AAEPoweredItemArmor(5000000, 0)
{
	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/aero.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister): Unit =
	{
		this.itemIcon = iconRegister.registerIcon("appaero:aerohelm")
	}
}
