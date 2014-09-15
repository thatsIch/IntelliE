package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.client


import java.util

import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseGuiContainer
import de.thatsich.minecraft.common.proxy.module.container.SlotSide
import de.thatsich.minecraft.common.proxy.module.gui.{Direction, GuiProgressBar}
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.{WorkbenchContainer, WorkbenchTileEntity}
import net.minecraft.client.gui.GuiButton
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.util.{ResourceLocation, StatCollector}


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

	private var progressBar: GuiProgressBar = null

	override def initGui(): Unit =
	{
		super.initGui()

		val resource = new ResourceLocation(AppliedAerodynamics.id, "textures/gui/workbench.png")
		this.progressBar = new GuiProgressBar(resource, this.guiLeft + 132, this.guiTop + 39, 179, 39, 6, 18, Direction.Vertical, this.workbench.maxModificationTime)

		val buttons: util.List[GuiButton] = this.buttonList.asInstanceOf[util.List[GuiButton]]
		buttons.add(this.progressBar)
	}

	def drawBG(offsetX: Int, offsetY: Int, mouseX: Int, mouseY: Int): Unit =
	{
		this.bindTexture("appaero", "textures/gui/workbench.png")

		this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize)
	}

	def drawFG(offsetX: Int, offsetY: Int, mouseX: Int, mouseY: Int): Unit =
	{
		this.progressBar.currentValue = this.workbench.modificationTime

		val workbench: String = StatCollector.translateToLocal("appaero.gui.workbench.name")
		val inventory: String = StatCollector.translateToLocal("appaero.gui.inventory.name")

		this.fontRendererObj.drawString(workbench, 8, 6, 0x404040)
		this.fontRendererObj.drawString(inventory, 8, 83, 0x404040)
	}
}


