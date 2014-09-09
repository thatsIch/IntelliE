package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.HorseShoesItemPowerStorage
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item.{ArmorType, BaseItemArmor}
import de.thatsich.minecraft.intellie.common.util.string.ID
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class SkyDiverItem(modid: ID, log: Log) extends BaseItemArmor(ArmorType.Helmet, modid, new SkyDiverID, log)
                                                         with HorseShoesItemPowerStorage
{
	this.setUnlocalizedName("helm")

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
