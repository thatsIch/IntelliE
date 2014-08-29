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
                     _width: Int,
                     _height: Int,
                     direction: Direction,
                     val maxValue: Int) extends GuiButton(xPos, yPos, _width, "")
                                                with ToolTip
{
	var currentValue = 0
	this.xPosition = this.xPos
	this.yPosition = this.yPos
	this.width = 0
	this.height = this._height

	override def drawButton(mc: Minecraft, x: Int, y: Int): Unit =
	{
		if (this.visible)
		{
			mc.getTextureManager.bindTexture(this.texture)

			this.direction match
			{
				case Direction.Vertical =>
					val diff = this._height - (if (this.maxValue > 0) this._height * this.currentValue / this.maxValue else 0)
					this.drawTexturedModalRect(this.xPos, this.yPos + diff, this.fillU, this.fillV + diff, this._width, this._height - diff)

				case Direction.Horizontal =>
					val diff = this._width - (if (this.maxValue > 0) this._width * this.currentValue / this.maxValue else 0)
					this.drawTexturedModalRect(this.xPos, this.yPos, this.fillU + diff, this.fillV, this._width - diff, this._height)
			}

			this.mouseDragged(mc, x, y)
		}
		super.drawButton(mc, x, y)
	}

	def toolTipMessage: String = s"$currentValue/$maxValue"

	def toolTipIsVisisble: Boolean = true

	def toolTipXActivationPos: Int = this.xPos - 2

	def toolTipActivationWidth: Int = this._width + 4

	def toolTipYActivationPos: Int = this.yPos - 2

	def toolTipActivationHeight: Int = this._height + 4
}
