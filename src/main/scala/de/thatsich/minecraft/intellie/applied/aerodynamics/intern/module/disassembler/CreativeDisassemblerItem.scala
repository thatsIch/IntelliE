package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.common.util.string.ID
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 03.09.2014.
 */
class CreativeDisassemblerItem(modid: ID, log: Log) extends DisassemblerItem(modid, log)
{
	override def getUnlocalizedName: String = s"${modid.id}.item.creativedisassembler"

	override def getCurrentMiningSpeed(is: ItemStack): Double = this.maxMiningSpeed

	override def getCurrentMiningLevel(is: ItemStack): Double = this.maxMiningLevel

	override def getCurrentDamageVsEntities(is: ItemStack): Double = this.maxDamageVsEntites

	override def getAEMaxPower(is: ItemStack): Double = this.maxEnergy

	override def getCurrentChargeMultiplier(is: ItemStack): Double = this.maxChargeMultiplier

	override def getCurrentEnergyUsage(is: ItemStack): Double = this.minEnergyUsage

	override def getAECurrentPower(is: ItemStack): Double = this.maxEnergy
}
