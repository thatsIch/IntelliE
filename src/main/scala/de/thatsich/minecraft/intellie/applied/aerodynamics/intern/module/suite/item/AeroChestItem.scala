package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.item.AAEPoweredItemArmor
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
class AeroChestItem extends AAEPoweredItemArmor(8000000, 1)
{
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
