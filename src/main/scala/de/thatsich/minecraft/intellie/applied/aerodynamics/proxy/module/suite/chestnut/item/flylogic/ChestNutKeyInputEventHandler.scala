package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.flylogic


import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.Minecraft


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private[item]
class ChestNutKeyInputEventHandler
{
	var isSneaking: Boolean = false
	var isJumping: Boolean = false

	var isForward: Boolean = false
	var isBackward: Boolean = false
	var isLeft: Boolean = false
	var isRight: Boolean = false

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	def onKeyInput(event: InputEvent.KeyInputEvent): Unit =
	{
		val mc = Minecraft.getMinecraft
		if (mc.thePlayer != null)
		{
			val settings = mc.gameSettings

			this.isJumping = settings.keyBindJump.getIsKeyPressed
			this.isSneaking = settings.keyBindSneak.getIsKeyPressed

			this.isForward = settings.keyBindForward.getIsKeyPressed
			this.isBackward = settings.keyBindBack.getIsKeyPressed
			this.isLeft = settings.keyBindLeft.getIsKeyPressed
			this.isRight = settings.keyBindRight.getIsKeyPressed
		}
	}
}
