package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler


import java.util

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseItem
import de.thatsich.minecraft.common.module.item.{PoweredItemDamageDisplay, UniqueItem, UnstackableItem}
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.{AEHumanNumberFormat, AEWrench, BlockBreakEventHandler, BreakSpeedHandler, MiningTool, PoweredItem, PrecisionHarvester, Weapon}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags.{PowerStorageTags, ToolTags, WeaponTags}
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import org.lwjgl.input.Keyboard


/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
private[disassembler] class DisassemblerItem(modid: ModID, log: Log)
extends BaseItem(new DisassemblerID, modid, log)
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
        with AEHumanNumberFormat
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

	override def getSubItems(item: Item, tabs: CreativeTabs, list: util.List[_]): Unit =
	{
		super.getSubItems(item, tabs, list)

		val stacks = list.asInstanceOf[util.List[ItemStack]]

		val stack = new ItemStack(this)
		val tag = this.getNBTData(stack)
		tag.setDouble(PowerStorageTags.CurrentEnergy, this.maxEnergy)
		tag.setDouble(PowerStorageTags.MaxEnergy, this.maxEnergy)
		tag.setDouble(PowerStorageTags.ChargeMultiplier, this.maxChargeMultiplier)
		tag.setDouble(PowerStorageTags.EnergyCost, this.minEnergyUsage)

		tag.setDouble(WeaponTags.Damage, this.maxDamageVsEntites)

		tag.setDouble(ToolTags.MiningLevel, this.maxMiningLevel)
		tag.setDouble(ToolTags.MiningSpeed, this.maxMiningSpeed)

		stacks.add(stack)
	}
}

