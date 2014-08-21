package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.container.slot.SlotSide
import de.thatsich.minecraft.common.module.gui.{Direction, GuiProgressBar, BaseGuiContainer}
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.{WorkbenchContainer, WorkbenchTileEntity}
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.{ResourceLocation, StatCollector}
import org.lwjgl.opengl.GL11


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
@SideOnly(Side.CLIENT)
class WorkbechGui(invPlayer: InventoryPlayer, workbench: WorkbenchTileEntity, log: Log) extends BaseGuiContainer(new WorkbenchContainer(invPlayer, workbench, log, SlotSide.Client))
{
	this.xSize = 176
	this.ySize = 176

	private var progressBar

	override def initGui(): Unit = {
		super.initGui()

		val resource = new ResourceLocation(AppliedAerodynamics.id, "textures/gui/workbench.png")
		this.progressBar = new GuiProgressBar(resource, 135, 39, 179, 39, 6, 18, Direction.Vertical)
	}

	def drawGuiContainerBackgroundLayer(f: Float, x: Int, y: Int): Unit =
	{
		// reset colors
		GL11.glColor4f(1, 1, 1, 1)

		Minecraft.getMinecraft.renderEngine.bindTexture(WorkbechGui.texture)
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize)

		if (this.workbench.isModifying)
		{
			val scaled: Int = this.workbench.getModificationProgressScaled(18)
			this.drawTexturedModalRect(this.guiLeft + 132, this.guiTop + 39 + 18 - scaled, 179, 39 + 18 - scaled, 6, scaled)
		}

		// draw more transparent
		GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS)
		GL11.glColor4f(1, 1, 1, 0.4F)
		GL11.glEnable(GL11.GL_BLEND)

		Minecraft.getMinecraft.renderEngine.bindTexture(WorkbechGui.tiles)
		this.drawTexturedModalRect(this.guiLeft + 39, this.guiTop + 40, 0, 0, 16, 16)
		this.drawTexturedModalRect(this.guiLeft + 59, this.guiTop + 40, 0, 16, 16, 16)

		// reset color
		GL11.glDisable(GL11.GL_BLEND)
		GL11.glColor4f(1, 1, 1, 1)
		GL11.glPopAttrib()
	}

	override def drawGuiContainerForegroundLayer(x: Int, y: Int): Unit =
	{
		val workbench: String = StatCollector.translateToLocal("appaero.gui.workbench.name")
		val inventory: String = StatCollector.translateToLocal("appaero.gui.inventory.name")

		this.fontRendererObj.drawString(workbench, 8, 6, 0x404040)
		this.fontRendererObj.drawString(inventory, 8, 83, 0x404040)
	}
}

private object WorkbechGui
{
	private final val texture: ResourceLocation = new ResourceLocation("appaero", "textures/gui/workbench.png")
	private final val tiles: ResourceLocation = new ResourceLocation("appaero", "textures/gui/tiles.png")
}


