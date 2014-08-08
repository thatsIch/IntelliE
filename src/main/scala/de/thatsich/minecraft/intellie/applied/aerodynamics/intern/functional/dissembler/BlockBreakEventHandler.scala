package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler


import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

import scala.collection.JavaConverters._


/**
 *
 *
 * @author thatsIch
 * @since 31.07.2014.
 */
private[dissembler] trait BlockBreakEventHandler
{
	MinecraftForge.EVENT_BUS.register(this)

	/**
	 * Interceps the HarvestDropsEvent.
	 * Adds the drops
	 *
	 * @param event incoming harvest drop event
	 */
	@SubscribeEvent
	def onHarvestDropsEvent(event: HarvestDropsEvent): Unit =
	{
		val player: EntityPlayer = event.harvester
		val heldItem: ItemStack = player.getHeldItem
		val item: Item = heldItem.getItem

		if (item.isInstanceOf[DissemblerItem])
		{
			val drops: Seq[ItemStack] = event.drops.asScala

			for (dropItemStack <- drops)
			{
				player.inventory.addItemStackToInventory(dropItemStack)
			}
		}
	}
}
