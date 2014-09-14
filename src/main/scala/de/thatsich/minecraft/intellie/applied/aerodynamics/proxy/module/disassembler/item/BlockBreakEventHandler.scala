package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


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
private[disassembler] trait BlockBreakEventHandler extends DisassemblerItemPowerStorage
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
		if (player == null) return

		val heldItemStack: ItemStack = player.getHeldItem
		if (heldItemStack == null) return

		val heldItem: Item = heldItemStack.getItem
		if (heldItem == null) return
		if (!heldItem.isInstanceOf[BlockBreakEventHandler]) return

		// put drops into inventory of player
		val drops: Seq[ItemStack] = event.drops.asScala
		val powerUsage = this.getCurrentEnergyUsage(heldItemStack)
		var power: Double = 0
		for (dropItemStack <- drops)
		{
			player.inventory.addItemStackToInventory(dropItemStack)
			power += powerUsage
		}
		this.extractAEPower(heldItemStack, power)
	}
}
