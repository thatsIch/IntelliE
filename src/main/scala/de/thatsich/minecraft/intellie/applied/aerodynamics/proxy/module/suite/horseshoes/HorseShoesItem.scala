package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.{HorseShoesItemPowerStorage, HorseShoesSpecialArmor}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item.{ArmorType, BasePoweredItemArmor}
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class HorseShoesItem(modid: ID, log: Log)
	extends BasePoweredItemArmor(ArmorType.Boots, modid, new HorseShoesID, log)
	        with HorseShoesItemPowerStorage
	        with HorseShoesSpecialArmor
{
	override def onUpdate(is: ItemStack, world: World, player: Entity, invIndex: Int, isHeldItem: Boolean): Unit =
	{
		println(invIndex)
		if (player.isSprinting)
		{
			val extracted = this.extractAEPower(is, this.config.initDischargePerTick)
			if (extracted > 0)
			{
				player.stepHeight = 1F
				player.fallDistance = 0
			}
			else
			{
				player.stepHeight = 0.5F
			}
		}
	}

	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/suit.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister): Unit =
	{
		this.itemIcon = iconRegister.registerIcon("appaero:horseshoes")
	}
}
