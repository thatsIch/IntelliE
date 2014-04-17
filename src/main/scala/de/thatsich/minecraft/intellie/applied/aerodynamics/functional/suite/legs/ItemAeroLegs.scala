package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.legs

import net.minecraft.item.ItemStack
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.renderer.texture.IIconRegister
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.module.item.AAEPoweredItemArmor
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class ItemAeroLegs(implicit creativeTab: CreativeTabs)
	extends AAEPoweredItemArmor(70000000, 2)
{
	private final val dischargeOnTick = 350

	override def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack)
	{
		val currentStorage = this.getAECurrentPower(itemStack)
		val newStorage = currentStorage
		this.extractAEPower(itemStack, this.dischargeOnTick)

		if( newStorage > 0 )
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
	override def registerIcons(iconRegister: IIconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("appaero:aerolegs")
	}
}
