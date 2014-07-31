package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import cpw.mods.fml.common.eventhandler.{EventPriority, SubscribeEvent}
import net.minecraftforge.client.event.MouseEvent
import net.minecraftforge.common.MinecraftForge

/**
 *
 *
 * @author thatsIch
 * @since 29.07.2014.
 */
private[ dissembler ] trait MouseEventHandler
{
	MinecraftForge.EVENT_BUS.register( this )

	var inUse = false

	/**
	 * set notInUse to true if right mouse button is released
	 *
	 * @param event mouse event
	 */
	@SubscribeEvent( priority = EventPriority.LOWEST )
	def onMouseEvent( event: MouseEvent ): Unit =
	{
		// button = 0, left mouse, button = 1, right mouse
		if( event.button == 1 && !event.buttonstate )
		{
			// buttonstate = true means button is pressed
			this.inUse = false
		}
	}
}
