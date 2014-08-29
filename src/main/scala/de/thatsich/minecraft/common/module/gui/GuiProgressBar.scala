package de.thatsich.minecraft.common.module.gui


import de.thatsich.minecraft.common.module.gui.Direction.Direction
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
                     xPos: Int,
                     yPos: Int,
                     fillU: Int,
                     fillV: Int,
                     width: Int,
                     height: Int,
                     direction: Direction,
	                 val maxValue: Int) extends GuiButton(xPos, yPos, width, "")
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
					this.drawTexturedModalRect(this.xPos, this.yPos + diff, this.fillU, this.fillV + diff, this.width, this.height - diff)

				case Direction.Horizontal =>
					val diff = this.width - (if (this.maxValue > 0) this.width * this.currentValue / this.maxValue else 0)
					this.drawTexturedModalRect(this.xPos, this.yPos, this.fillU + diff, this.fillV, this.width - diff, this.height)
			}

			this.mouseDragged(mc, x, y)
		}
		super.drawButton(mc, x, y)
	}

	def toolTipMessage: String = s"$currentValue/$maxValue"

	def toolTipIsVisisble: Boolean = true

	def toolTipXActivationPos: Int = this.xPos - 2

	def toolTipActivationWidth: Int = this.width + 4

	def toolTipYActivationPos: Int = this.yPos - 2

	def toolTipActivationHeight: Int = this.height + 4
}
