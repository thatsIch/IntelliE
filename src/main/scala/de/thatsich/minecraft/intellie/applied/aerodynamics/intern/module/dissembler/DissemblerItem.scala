package de.thatsich.minecraft
package intellie
package applied
package aerodynamics
package intern
package module
package dissembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.BaseItem
import de.thatsich.minecraft.common.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item.{AEPowerStorage, AEWrench, BlockBreakEventHandler, BreakSpeedHandler, HumanNumberFormat, MiningTool, PrecisionHarvester, SpecialTool, UniqueItem, UnstackableItem, Weapon}
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
class DissemblerItem(modid: ID, name: ID, log: Log) extends BaseItem(modid, name, log)
                                                            with AEWrench
                                                            with PrecisionHarvester
                                                            with BlockBreakEventHandler
                                                            with AEPowerStorage
                                                            with Weapon
                                                            with MiningTool
                                                            with BreakSpeedHandler
                                                            with SpecialTool
                                                            with UnstackableItem
                                                            with UniqueItem
                                                            with HumanNumberFormat
{
	override def addInformation(is: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(is)
		val roundCurrent = currentPower.toInt

		val maxPower = this.getAEMaxPower(is)
		val roundMax = maxPower.toInt
		val percent = (currentPower / maxPower * 100).toInt

		val list = information.asInstanceOf[java.util.List[String]]

		// add additional information when sneaking
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			val energyBlockBreak: Double = this.getCurrentEnergyPerBlockBreak(is)
			val multiplier: Double = this.getCurrentChargeMultiplier(is)
			val speed: Int = this.getCurrentMiningSpeed(is)
			val level: Int = this.getCurrentMiningLevel(is)
			val damage: Double = this.getCurrentDamageVsEntities(is)

			list.add(s"Stored Energy: $roundCurrent/$roundMax AE - $percent%")
			list.add(s"Energy Cost: $energyBlockBreak")
			list.add(s"Charge multiplier: $multiplier")

			list.add(s"Mining Speed: $speed")
			list.add(s"Mining Level: $level")

			list.add(s"Damage: $damage")
		}
		else
		{
			val shortCurrent = this.readableForm(roundCurrent)
			list.add(s"Stored Energy: $shortCurrent AE - $percent%")
			list.add("Hold shift for more information")
		}
	}

	override def canHarvestBlock(block: Block, is: ItemStack): Boolean =
	{
		val harvestLevel: Int = block.getHarvestLevel(0)
		val currentMiningLevel: Int = this.getCurrentMiningLevel(is)

		val currentEnergy = this.getAECurrentPower(is)
		val energyUsage = this.getCurrentEnergyPerBlockBreak(is)

		currentMiningLevel >= harvestLevel && currentEnergy >= energyUsage
	}
}

