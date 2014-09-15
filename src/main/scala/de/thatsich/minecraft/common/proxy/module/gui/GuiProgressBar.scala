package de.thatsich.minecraft.common.proxy.module.gui


import de.thatsich.minecraft.common.proxy.module.gui.Direction.Direction
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.util.ResourceLocation


/**
 *
 *
 * @author thatsIch
 * @since 20.08.2014.
 */
class GuiProgressBar(texture: ResourceLocation,
                     xPosition: Int,
                     yPosition: Int,
                     fillU: Int,
                     fillV: Int,
                     width: Int,
                     height: Int,
                     direction: Direction,
                     val maxValue: Int) extends GuiButton(xPosition, yPosition, width, "")
                                                with ToolTip
{
	var currentValue = 0

	override def drawButton(mc: Minecraft, x: Int, y: Int): Unit =
	{
		if (this.visible)
		{
			mc.getTextureManager.bindTexture(this.texture)

			this.direction match
			{
				case Direction.Vertical =>
					val diff = this.height - (if (this.maxValue > 0) this.height * this.currentValue / this.maxValue else 0)
					this.drawTexturedModalRect(this.xPosition, this.yPosition + diff, this.fillU, this.fillV + diff, this.width, this.height - diff)

				case Direction.Horizontal =>
					val diff = this.width - (if (this.maxValue > 0) this.width * this.currentValue / this.maxValue else 0)
					this.drawTexturedModalRect(this.xPosition, this.yPosition, this.fillU + diff, this.fillV, this.width - diff, this.height)
			}

			this.mouseDragged(mc, x, y)
		}
	}

	def toolTipMessage: String = s"$currentValue/$maxValue"

	def toolTipIsVisisble: Boolean = true

	def toolTipXActivationPos: Int = this.xPosition - 2

	def toolTipActivationWidth: Int = this.width + 4

	def toolTipYActivationPos: Int = this.yPosition - 2

	def toolTipActivationHeight: Int = this.height + 4
}
