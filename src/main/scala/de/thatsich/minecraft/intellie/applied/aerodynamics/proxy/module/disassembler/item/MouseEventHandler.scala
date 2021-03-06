package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import cpw.mods.fml.common.eventhandler.{EventPriority, SubscribeEvent}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraftforge.client.event.MouseEvent
import net.minecraftforge.common.MinecraftForge


/**
 * Tracks the state of the right mouse button.
 * resets the use state when it is released
 *
 * @author thatsIch
 * @since 29.07.2014.
 */
private[disassembler] trait MouseEventHandler
{
	MinecraftForge.EVENT_BUS.register(this)

	protected var inUse = false

	/**
	 * set notInUse to true if right mouse button is released
	 *
	 * @param event mouse event
	 */
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOWEST)
	def onMouseEvent(event: MouseEvent): Unit =
	{
		// button = 0, left mouse, button = 1, right mouse
		if (event.button == 1 && !event.buttonstate)
		{
			// buttonstate = true means button is pressed
			this.inUse = false
		}
	}
}
