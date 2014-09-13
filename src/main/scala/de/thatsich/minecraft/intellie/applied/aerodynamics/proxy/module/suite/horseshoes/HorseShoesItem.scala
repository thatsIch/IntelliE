package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import java.util

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.PoweredItemDamageDisplay
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.AEHumanNumberFormat
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags.{LogicTags, ArmorTags, PowerStorageTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.{HorseShoesItemPowerStorage, HorseShoesSpecialArmor, HorseShoesStepHeightLogic}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.item.{ArmorType, BaseItemArmor}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import org.lwjgl.input.Keyboard


/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
// TODO upgrades
class HorseShoesItem(modid: ModID, log: Log)
	extends BaseItemArmor(ArmorType.Boots, modid, new HorseShoesID, log)
	        with HorseShoesItemPowerStorage
	        with HorseShoesSpecialArmor
	        with PoweredItemDamageDisplay
	        with AEHumanNumberFormat
	        with HorseShoesStepHeightLogic
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
			val stepheight = this.getStepHeight(is)

			val absorptionratio = this.getAbsorptionRatio(is)
			val armorbase = this.getArmorBase(is).toInt

			val energyperdamage = this.getEnergyPerDamage(is).toInt
			val discharge = this.getDischargePerTick(is).toInt
			val chargemultiplier = this.getCurrentChargeMultiplier(is).toInt

			list.add(s"Stored Energy: $currentPower/$maxPower AE - $percent%")
			list.add(s"Charge Multiplier: $chargemultiplier")
			list.add(s"Discharge per Tick: $discharge")
			list.add(s"Energy per Damage: $energyperdamage")
			list.add(s"Absorptionratio: $absorptionratio")
			list.add(s"Armorbase: $armorbase")
			list.add(s"Stepheight: $stepheight")
		}
		else
		{
			val shortCurrent = this.readableForm(currentPower)
			list.add(s"Stored Energy: $shortCurrent - $percent%")
			list.add("Hold shift for more information")
		}
	}

	override def getSubItems(item : Item, tabs : CreativeTabs, itemstacks : util.List[_]): Unit = {
		super.getSubItems(item, tabs, itemstacks)

		val list = itemstacks.asInstanceOf[util.List[ItemStack]]

		val stack = new ItemStack(this)
		val tag = this.getNBTData(stack)
		tag.setDouble(PowerStorageTags.CurrentEnergy, this.maxEnergy)
		tag.setDouble(PowerStorageTags.MaxEnergy, this.maxEnergy)
		tag.setDouble(PowerStorageTags.ChargeMultiplier, this.maxChargeMultiplier)
		tag.setDouble(PowerStorageTags.DischargePerTick, this.minDischargePerTick)

		tag.setDouble(ArmorTags.EnergyPerDamage, this.minEnergyPerDamagePoint)
		tag.setDouble(ArmorTags.ArmorBase, this.maxArmorBase)
		tag.setDouble(ArmorTags.AbsorptionRatio, this.maxAbsorptionRatio)

		tag.setDouble(LogicTags.StepHeight, this.maxStepHeight)

		list.add(stack)
	}
}
