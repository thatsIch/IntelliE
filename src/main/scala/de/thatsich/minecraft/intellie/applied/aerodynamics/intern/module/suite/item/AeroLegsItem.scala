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
 * @since 16.04.2014.
 */
class AeroLegsItem extends AAEPoweredItemArmor(7000000, 2)
{
	private final val dischargeOnTick = 70

	override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack): Unit =
	{
		val currentStorage = this.getAECurrentPower(itemStack)
		val newStorage = currentStorage
		this.extractAEPower(itemStack, this.dischargeOnTick)

		if (newStorage > 0)
		{
			player.capabilities.setPlayerWalkSpeed(0.11F)
			player.capabilities.setFlySpeed(0.1F)
		}
		else
		{
			player.capabilities.setPlayerWalkSpeed(0.1F)
			player.capabilities.setFlySpeed(0.05F)
		}
	}

	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/aero.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister): Unit =
	{
		this.itemIcon = iconRegister.registerIcon("appaero:aerolegs")
	}
}
