package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.steplogic


import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemArmor
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent


/**
 * 
 *
 * @author thatsIch
 * @since 12.09.2014.
 */
class HorseShoesLivingUpdateEventHandler(armor: ItemArmor)
{
	/**
	 * reset player step height, when shoes were unequipped
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
					if (armor == null || armor.getItem != this.armor)
					{
						player.stepHeight = 0.5F
					}

				case _ =>
			}
		}
	}
}
