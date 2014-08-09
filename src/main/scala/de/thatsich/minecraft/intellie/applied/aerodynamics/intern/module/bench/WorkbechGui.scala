package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.ResourceLocation
import org.lwjgl.opengl.GL11


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
@SideOnly(Side.CLIENT)
class WorkbechGui(invPlayer: InventoryPlayer, workbench: WorkbenchTileEntity) extends GuiContainer(new WorkbenchContainer(invPlayer, workbench))
{
	this.xSize = 176
	this.ySize = 176

	def drawGuiContainerBackgroundLayer(f: Float, x: Int, y: Int): Unit =
	{
		// reset colors
		GL11.glColor4f(1, 1, 1, 1)

		Minecraft.getMinecraft.renderEngine.bindTexture(WorkbechGui.texture)
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize)
	}

	override def drawGuiContainerForegroundLayer(x: Int, y: Int): Unit =
	{
		this.fontRendererObj.drawString("Modification Workbench", 8, 6, 0x404040)
		this.fontRendererObj.drawString("Inventory", 8, 83, 0x404040)
	}
}

object WorkbechGui
{
	private final val texture: ResourceLocation = new ResourceLocation("appaero", "textures/gui/workbench.png")
}


