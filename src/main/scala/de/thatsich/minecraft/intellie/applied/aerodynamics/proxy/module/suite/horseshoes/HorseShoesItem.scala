package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.PoweredItemDamageDisplay
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.AEHumanNumberFormat
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.{HorseShoesItemPowerStorage, HorseShoesSpecialArmor}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item.{ArmorType, BaseItemArmor}
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent
import org.lwjgl.input.Keyboard


/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
class HorseShoesItem(modid: ID, log: Log)
	extends BaseItemArmor(ArmorType.Boots, modid, new HorseShoesID, log)
	        with HorseShoesItemPowerStorage
	        with HorseShoesSpecialArmor
	        with PoweredItemDamageDisplay
	        with AEHumanNumberFormat
{
	MinecraftForge.EVENT_BUS.register(this)

	override def addInformation(is: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(is).toInt
		val maxPower = this.getAEMaxPower(is).toInt
		val percent = if (maxPower == 0) 0 else 100 * (currentPower / maxPower)

		val list = information.asInstanceOf[java.util.List[String]]

		// add additional information when sneaking
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			val multiplier = this.getCurrentChargeMultiplier(is).toInt
			val discharge = this.getDischargePerTick(is).toInt

			list.add(s"Stored Energy: $currentPower/$maxPower AE - $percent%")
			list.add(s"Charge Multiplier: $multiplier")
			list.add(s"Discharge per Tick: $discharge")
		}
		else
		{
			val shortCurrent = this.readableForm(currentPower)
			list.add(s"Stored Energy: $shortCurrent - $percent%")
			list.add("Hold shift for more information")
		}
	}

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

				case _ =>
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
