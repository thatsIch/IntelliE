package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.legs


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.string.id.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.item.ItemPowerStorage
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item.{ArmorType, BaseItemArmor}
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
class FreeRunnerItem(modid: ID, log: Log) extends BaseItemArmor(ArmorType.Boots, modid, new FreeRunnerID, log)
                                                          with ItemPowerStorage
{
	this.setUnlocalizedName("legs")
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
