package de.thatsich.minecraft.common.module.gui


import java.util

import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client.HoloSlot
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.gui.{GuiButton, GuiScreen}
import net.minecraft.client.renderer.RenderHelper
import net.minecraft.inventory.{Container, Slot}
import net.minecraft.util.ResourceLocation
import org.lwjgl.opengl.GL11

import scala.collection.JavaConverters._
import scala.collection.mutable


/**
 *
 *
 * @author thatsIch
 * @since 20.08.2014.
 */
abstract class BaseGuiContainer(container: Container) extends GuiContainer(container)
{
	def drawGuiContainerBackgroundLayer(f: Float, x: Int, y: Int): Unit =
	{
		// reset colors
		GL11.glColor4f(1, 1, 1, 1)
		this.drawBG(this.guiLeft, this.guiTop, x, y)
		val slots: util.List[Slot] = this.inventorySlots.inventorySlots.asInstanceOf[util.List[Slot]]
		val slotBuffer: mutable.Buffer[Slot] = slots.asScala

		this.drawHoloIcons(slotBuffer)
	}

	override def drawGuiContainerForegroundLayer(x: Int, y: Int): Unit =
	{
		this.drawFG(this.guiLeft, this.guiTop, x, y)
	}

	def drawBG(offsetX: Int, offsetY: Int, mouseX: Int, mouseY: Int): Unit

	def drawFG(offsetX: Int, offsetY: Int, mouseX: Int, mouseY: Int): Unit

	private def drawHoloIcons(slots: mutable.Buffer[Slot]): Unit =
	{
		slots.foreach
		{
			case holo: HoloSlot => this.drawHoloIcon(holo)
			case _              =>
		}
	}

	private def drawHoloIcon(slot: HoloSlot): Unit =
	{
		if (slot != null && !slot.getHasStack)
		{
			GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS)
			GL11.glColor4f(1, 1, 1, 0.4F)
			GL11.glEnable(GL11.GL_BLEND)

			this.bindTexture(slot.textureNamespace, slot.texturePath)

			this.drawTexturedModalRect(this.guiLeft + slot.xDisplayPosition, this.guiTop + slot.yDisplayPosition, slot.holoSlotOffsetX, slot.holoSlotOffsetY, 16, 16)

			GL11.glDisable(GL11.GL_BLEND)
			GL11.glColor4f(1, 1, 1, 1)
			GL11.glPopAttrib()
		}
	}

	def bindTexture(base: String, location: String): Unit =
	{
		val res = new ResourceLocation(base, location)
		Minecraft.getMinecraft.renderEngine.bindTexture(res)
	}

	override def drawScreen(mouseX: Int, mouseY: Int, btn: Float): Unit =
	{
		super.drawScreen(mouseX, mouseY, btn)

		val buttons: mutable.Buffer[GuiButton] = this.buttonList.asInstanceOf[util.List[GuiButton]].asScala
		buttons.foreach
		{
			case tooltip: ToolTip =>
				val ttx = tooltip.toolTipXActivationPos
				val tty = tooltip.toolTipYActivationPos
				val ttw = tooltip.toolTipActivationWidth
				val tth = tooltip.toolTipActivationHeight

				val isVisisble = tooltip.toolTipIsVisisble
				val isContainedHorizontally = ttx < mouseX && mouseX < ttx + ttw
				val isContainedVertically = tty < mouseY && mouseY < tty + tth

				if (isVisisble && isContainedHorizontally && isContainedVertically)
				{
					val ttyAlignment = tty max 15
					val message = tooltip.toolTipMessage
					this.drawToolTip(ttx + 11, ttyAlignment + 4, 0, message)
				}

			case _ =>
		}
	}

	private def drawToolTip(x: Int, y: Int, forceWidth: Int, msg: String): Unit =
	{
		GL11.glPushAttrib(1048575)
		GL11.glDisable(32826)
		RenderHelper.disableStandardItemLighting()
		GL11.glDisable(2896)
		GL11.glDisable(2929)

		val splitMessage: Array[String] = msg.split("\n")
		if (splitMessage.length > 0)
		{
			var var5 = 0
			for (split <- splitMessage)
			{
				val stringWidth: Int = this.fontRendererObj.getStringWidth(split)
				if (stringWidth > var5)
				{
					var5 = stringWidth
				}
			}

			val var6 = x + 12
			var var7 = y - 12
			var var9 = 8
			if (splitMessage.length > 1)
			{
				var9 += 2 + (splitMessage.length - 1) * 10
			}
			if (this.guiTop + var7 + var9 + 6 > this.height)
			{
				var7 = this.height - var9 - this.guiTop - 6
			}
			if (forceWidth > 0)
			{
				var5 = forceWidth
			}

			this.zLevel = 300.0F
			GuiScreen.itemRender.zLevel = 300.0F
			val var10 = -267386864
			drawGradientRect(var6 - 3, var7 - 4, var6 + var5 + 3, var7 - 3, var10, var10)
			drawGradientRect(var6 - 3, var7 + var9 + 3, var6 + var5 + 3, var7 + var9 + 4, var10, var10)
			drawGradientRect(var6 - 3, var7 - 3, var6 + var5 + 3, var7 + var9 + 3, var10, var10)
			drawGradientRect(var6 - 4, var7 - 3, var6 - 3, var7 + var9 + 3, var10, var10)
			drawGradientRect(var6 + var5 + 3, var7 - 3, var6 + var5 + 4, var7 + var9 + 3, var10, var10)
			val var11 = 1347420415
			val var12 = (var11 & 0xFEFEFE) >> 1 | var11 & 0xFF000000
			drawGradientRect(var6 - 3, var7 - 3 + 1, var6 - 3 + 1, var7 + var9 + 3 - 1, var11, var12)
			drawGradientRect(var6 + var5 + 2, var7 - 3 + 1, var6 + var5 + 3, var7 + var9 + 3 - 1, var11, var12)
			drawGradientRect(var6 - 3, var7 - 3, var6 + var5 + 3, var7 - 3 + 1, var11, var11)
			drawGradientRect(var6 - 3, var7 + var9 + 2, var6 + var5 + 3, var7 + var9 + 3, var12, var12)
			for (var13 <- 0 until splitMessage.length)
			{
				var var14 = splitMessage(var13)
				if (var13 == 0)
				{
					var14 = "§" + Integer.toHexString(15) + var14
				} else
				{
					var14 = "§7" + var14
				}
				this.fontRendererObj.drawStringWithShadow(var14, var6, var7, -1)
				if (var13 == 0)
				{
					var7 += 2
				}
				var7 += 10
			}
			this.zLevel = 0.0F
			GuiScreen.itemRender.zLevel = 0.0F
		}
		GL11.glPopAttrib()
	}
}
