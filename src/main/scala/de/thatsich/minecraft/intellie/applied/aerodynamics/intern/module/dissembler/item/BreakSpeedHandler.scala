package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import cpw.mods.fml.common.eventhandler.SubscribeEvent
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.DissemblerItem
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait BreakSpeedHandler
{
	MinecraftForge.EVENT_BUS.register(this)

	@SubscribeEvent
	def onBreakSpeed(event: BreakSpeed): Unit =
	{
		val player = event.entityPlayer
		if (player == null) return

		val heldItemStack = player.getHeldItem
		if (heldItemStack == null) return

		val heldItem = heldItemStack.getItem
		if (!heldItem.isInstanceOf[DissemblerItem]) return

//		println(event.)

//		event.setCanceled(true)
	}
}
