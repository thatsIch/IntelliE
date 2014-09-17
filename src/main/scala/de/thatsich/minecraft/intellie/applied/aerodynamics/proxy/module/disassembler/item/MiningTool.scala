package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import de.thatsich.minecraft.common.proxy.module.util.NBTAccess
import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags.ToolTags
import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait MiningTool
extends Item
        with DisassemblerItemPowerStorage
        with NBTAccess
        with BoundDetection
{
	def toolTags: ToolTags

	/**
	 * gets the mining speed
	 *
	 * @param is ItemStack of this
	 * @param block Mining block
	 * @param metadata metadata of block
	 *
	 * @return configured mining speed
	 */
	override def getDigSpeed(is: ItemStack, block: Block, metadata: Int): Float = this.getCurrentMiningSpeed(is).toFloat

	def getCurrentMiningSpeed(is: ItemStack): Int = if (this.getAECurrentPower(is) >= this.getCurrentEnergyUsage(is)) this.withinBounds(is, this.toolTags.MiningSpeed) else 0

	def getCurrentMiningLevel(is: ItemStack): Int = this.withinBounds(is, this.toolTags.MiningLevel)
}