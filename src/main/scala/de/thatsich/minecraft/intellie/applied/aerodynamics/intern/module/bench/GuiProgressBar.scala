package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.Direction.Direction
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.util.ResourceLocation


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class GuiProgressBar(resourcePath: String, posX: Int, posY: Int, fill_u: Int, fill_v: Int, width: Int, height: Int, direction: Direction) extends GuiButton(posX, posY, width, "")
{
	val texture: ResourceLocation = new ResourceLocation("appaero", "texture/" + resourcePath)
	var current: Int = 0
	var max: Int = 100

	override def drawButton(minecraft: Minecraft, x: Int, y: Int): Unit =
	{
		if (this.visible)
		{

			minecraft.getTextureManager.bindTexture(this.texture)

			this.direction match
			{
				case Direction.VERTICAL =>
					val currentHeight: Int = 0 max (this.height * this.current / this.max)
					val diff: Int = this.height - currentHeight
					drawTexturedModalRect(this.xPosition, this.yPosition + diff, this.fill_u, this.fill_v + diff, this.width, this.height - diff)

				case Direction.HORIZONTAL =>
					val currentWidth: Int = 0 max (this.width * this.current / this.max)
					val diff: Int = this.width - currentWidth
					this.drawTexturedModalRect(this.xPosition + diff, this.yPosition, this.fill_u, this.fill_v + diff, this.width - diff, this.height)
			}
		}

		mouseDragged(minecraft, x, y)
	}

	def xPos: Int = this.xPosition - 2

	def yPos: Int = this.yPosition - 2

	def getWidth: Int = this.width + 4

	def getHeight: Int = this.height + 4

	def isVisisble: Boolean = true
}
