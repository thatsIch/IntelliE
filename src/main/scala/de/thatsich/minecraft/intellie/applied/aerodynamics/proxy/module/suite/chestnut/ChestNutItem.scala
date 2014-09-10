package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.HorseShoesItemPowerStorage
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item.{ArmorType, BaseItemArmor}
import de.thatsich.minecraft.intellie.common.util.string.ID
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
abstract class ChestNutItem(modid: ID, log: Log) extends BaseItemArmor(ArmorType.Boots, modid, new ChestNutID, log)
                                                         with HorseShoesItemPowerStorage
{
	this.setUnlocalizedName("chest")
	final val disChargeOnTick = 80

	override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack): Unit =
	{
		val currentStorage = this.getAECurrentPower(itemStack)
		var newStorage = currentStorage
		if (player.capabilities.isFlying)
		{
			newStorage = this.extractAEPower(itemStack, this.disChargeOnTick)
		}

		if (newStorage > 0)
		{
			player.capabilities.allowFlying = true
		}
		else
		{
			player.capabilities.allowFlying = false
			player.capabilities.isFlying = false
		}
	}

	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/aero.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister): Unit =
	{
		this.itemIcon = iconRegister.registerIcon("appaero:aerochest")
	}
}
