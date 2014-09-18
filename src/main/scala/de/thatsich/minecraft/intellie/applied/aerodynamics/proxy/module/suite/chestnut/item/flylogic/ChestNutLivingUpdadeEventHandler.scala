package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.flylogic


import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemArmor
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private [item]
class ChestNutLivingUpdadeEventHandler(armor: ItemArmor)
{
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
					val armor = player.inventory.armorItemInSlot(2)
					if (armor == null || armor.getItem != this.armor)
					{
						player.capabilities.allowFlying = false
						player.capabilities.isFlying = false
//						player.capabilities.setFlySpeed()
						// TODO somehow set flyspeed
					}

				case _ =>
			}
		}
	}
}
