package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.movementlogic


import java.util.UUID

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{EntityLivingBase, SharedMonsterAttributes}
import net.minecraft.item.ItemArmor
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent


/**
 * 
 *
 * @author thatsIch
 * @since 18.09.2014.
 */
private[item]
class FreeRunnerLivingUpdateEventHandler(armor: ItemArmor, modifierID: UUID)
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
					val armor = player.inventory.armorItemInSlot(1)
					if (armor == null || armor.getItem != this.armor)
					{
						val attribute = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed)

						val modifier = attribute.getModifier(this.modifierID)
						if (modifier != null)
						{
							attribute.removeModifier(modifier)
						}
					}

				case _ =>
			}
		}
	}
}
