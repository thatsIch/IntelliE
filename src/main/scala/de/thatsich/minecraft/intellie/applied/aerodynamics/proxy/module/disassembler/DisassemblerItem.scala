package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseItem
import de.thatsich.minecraft.common.module.item.{PoweredItemDamageDisplay, UniqueItem, UnstackableItem}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.{AEWrench, BlockBreakEventHandler, BreakSpeedHandler, HumanNumberFormat, MiningTool, PoweredItem, PrecisionHarvester, Weapon}
import de.thatsich.minecraft.intellie.common.util.string.ID
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import org.lwjgl.input.Keyboard


/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
private[disassembler] class DisassemblerItem(modid: ID, log: Log) extends BaseItem(modid, new DisassemblerID, log)
                                                                          with AEWrench
                                                                          with PrecisionHarvester
                                                                          with BlockBreakEventHandler
                                                                          with PoweredItem
                                                                          with Weapon
                                                                          with MiningTool
                                                                          with BreakSpeedHandler
                                                                          with PoweredItemDamageDisplay
                                                                          with UnstackableItem
                                                                          with UniqueItem
                                                                          with HumanNumberFormat
{
	override def addInformation(is: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(is).toInt
		val maxPower = this.getAEMaxPower(is).toInt
		val percent = if (maxPower == 0) 0 else 100 * (currentPower / maxPower)

		val list = information.asInstanceOf[java.util.List[String]]

		// add additional information when sneaking
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			val energyUsage = this.getCurrentEnergyUsage(is).toInt
			val multiplier = this.getCurrentChargeMultiplier(is).toInt
			val speed = this.getCurrentMiningSpeed(is).toInt
			val level = this.getCurrentMiningLevel(is).toInt
			val damage = this.getCurrentDamageVsEntities(is).toInt

			list.add(s"Stored Energy: $currentPower/$maxPower AE - $percent%")
			list.add(s"Energy Cost: $energyUsage")
			list.add(s"Charge Multiplier: $multiplier")

			list.add(s"Mining Speed: $speed")
			list.add(s"Mining Level: $level")

			list.add(s"Damage: $damage")
		}
		else
		{
			val shortCurrent = this.readableForm(currentPower)
			list.add(s"Stored Energy: $shortCurrent - $percent%")
			list.add("Hold shift for more information")
		}
	}

	override def canHarvestBlock(block: Block, is: ItemStack): Boolean =
	{
		val harvestLevel: Int = block.getHarvestLevel(0)
		val currentMiningLevel: Double = this.getCurrentMiningLevel(is)

		val currentEnergy = this.getAECurrentPower(is)
		val energyUsage = this.getCurrentEnergyUsage(is)

		currentMiningLevel >= harvestLevel && currentEnergy >= energyUsage
	}
}

