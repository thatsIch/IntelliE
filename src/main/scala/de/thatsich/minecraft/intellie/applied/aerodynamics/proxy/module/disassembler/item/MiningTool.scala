package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import de.thatsich.minecraft.common.module.util.NBTAccess
import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags.ToolTags
import net.minecraft.block.Block
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait MiningTool
extends PoweredItem
        with NBTAccess
        with DisassemblerConfigAccess
        with NBTKeyStorage
        with BoundDetection
{
	this.addNBTs(ToolTags)

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

	def getCurrentMiningSpeed(is: ItemStack): Double = if (this.getAECurrentPower(is) >= this.getCurrentEnergyUsage(is)) this.withinBounds(is, ToolTags.MiningSpeed) else 0

	def setCurrentMiningSpeed(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(ToolTags.MiningSpeed, value)

	def getCurrentMiningLevel(is: ItemStack): Double = this.withinBounds(is, ToolTags.MiningLevel)

	def setCurrentMiningLevel(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(ToolTags.MiningLevel, value)
}