package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.suite.chest


import cpw.mods.fml.client.registry.ClientRegistry
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent
import net.minecraft.client.settings.KeyBinding
import org.lwjgl.input.Keyboard


object KeyHandler
{
	private final val FLY_KEY: Int = Keyboard.KEY_G
	private final val BINDING: KeyBinding = new KeyBinding("description", KeyHandler.FLY_KEY, "FLY_KEY.category")
}

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class KeyHandler
{
	ClientRegistry.registerKeyBinding(KeyHandler.BINDING)

	@SubscribeEvent def onKeyInput(event: InputEvent.KeyInputEvent): Unit =
	{
		if (KeyHandler.BINDING.isPressed)
		{
			System.out.println("PRESSED")
		}
	}
}
