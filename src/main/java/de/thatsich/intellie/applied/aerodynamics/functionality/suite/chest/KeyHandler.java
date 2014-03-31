package de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * @author thatsIch
 * @date 26.03.2014.
 */
public class KeyHandler {
	private static final int FLY_KEY = Keyboard.KEY_G;
	private static final KeyBinding BINDING = new KeyBinding("description", KeyHandler.FLY_KEY, "FLY_KEY.category");

	public KeyHandler() {
		ClientRegistry.registerKeyBinding(KeyHandler.BINDING);
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (KeyHandler.BINDING.isPressed()) {
			System.out.println("PRESSED");
			//			AppliedAerodynamics.packetPipeline.sendToServer( new FlyPacket() );
		}
	}
}
