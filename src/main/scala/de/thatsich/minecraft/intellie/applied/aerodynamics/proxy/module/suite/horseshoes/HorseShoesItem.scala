package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.{HorseShoesItemPowerStorage, HorseShoesSpecialArmor}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item.{ArmorType, BasePoweredItemArmor}
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent


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
	MinecraftForge.EVENT_BUS.register(this)

	/**
	 * reset player step height
	 */
	@SubscribeEvent
	def onLivingUpdateEvent(event: LivingUpdateEvent): Unit =
	{
		val entity: EntityLivingBase = event.entityLiving
		if (entity != null)
		{
			entity match
			{
				case player: EntityPlayer =>
					val armor = player.inventory.armorItemInSlot(0)
					if (armor == null || armor.getItem != this)
					{
						player.stepHeight = 0.5F
					}
			}
		}
	}

	/**
	 * Ticks every tick when equiped in armor slot
	 * when player is sprinting and has enough power
	 * power is drained and the stepheight is increased
	 */
	override def onArmorTick(world: World, player: EntityPlayer, is: ItemStack): Unit =
	{
		val currentpower = this.getAECurrentPower(is)
		val discharge = this.getDischargePerTick(is)

		if (player.isSprinting && currentpower >= discharge)
		{
			this.extractAEPower(is, discharge)

			player.stepHeight = 1F
			player.fallDistance = 0
		}
		else
		{
			player.stepHeight = 0.5F
		}
	}

	override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String =
	{
		"appaero:textures/models/suite.png"
	}

	@SideOnly(Side.CLIENT)
	override def registerIcons(iconRegister: IIconRegister): Unit =
	{
		this.itemIcon = iconRegister.registerIcon("appaero:horseshoes")
	}
}
