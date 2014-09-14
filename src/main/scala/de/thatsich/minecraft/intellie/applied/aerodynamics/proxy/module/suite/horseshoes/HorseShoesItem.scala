package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import java.util

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.{NBTKeyStorage, PoweredItemDamageDisplay}
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.AEHumanNumberFormat
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config.{HorseShoesArmorConfigAccess, HorseShoesConfig, HorseShoesFunctionalityConfigAccess, HorseShoesItemPowerStorageConfigAccess}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags.{ArmorTags, FunctionalityTags, ItemPowerStorageTags}
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
        with NBTKeyStorage
{
	val config = new HorseShoesConfig

	val armorConfig = new HorseShoesArmorConfigAccess(this.config)
	val functionalityConfig = new HorseShoesFunctionalityConfigAccess(this.config)
	val powerConfig = new HorseShoesItemPowerStorageConfigAccess(this.config)

	val armorTags = new ArmorTags(this.armorConfig)
	val functionalityTags = new FunctionalityTags(this.functionalityConfig)
	val powerTags = new ItemPowerStorageTags(this.powerConfig)

	this.addNBTs(this.armorTags)
	this.addNBTs(this.functionalityTags)
	this.addNBTs(this.powerTags)

	override def addInformation(is: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(is).toInt
		val maxPower = this.getAEMaxPower(is).toInt
		val percent = if (maxPower == 0) 0 else 100 * (currentPower / maxPower)

		val list = information.asInstanceOf[java.util.List[String]]

		// add additional information when sneaking
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			list.add(s"Stored Energy: $currentPower/$maxPower AE - $percent%")
			list.add(s"Charge Multiplier: ${this.getCurrentChargeMultiplier(is).toInt}")
			list.add(s"Discharge per Tick: ${this.getDischargePerTick(is).toInt}")
			list.add(s"Energy per Damage: ${this.getEnergyPerDamage(is).toInt}")
			list.add(s"Absorptionratio: ${this.getAbsorptionRatio(is)}")
			list.add(s"Armorbase: ${this.getArmorBase(is).toInt}")
			list.add(s"Stepheight: ${this.getStepHeight(is)}")
		}
		else
		{
			val shortCurrent = this.readableForm(currentPower)
			list.add(s"Stored Energy: $shortCurrent - $percent%")
			list.add("Hold shift for more information")
		}
	}

	override def getSubItems(item: Item, tabs: CreativeTabs, itemstacks: util.List[_]): Unit =
	{
		super.getSubItems(item, tabs, itemstacks)

		val list = itemstacks.asInstanceOf[util.List[ItemStack]]

		val stack = new ItemStack(this)
		val tag = this.getNBTData(stack)
		tag.setDouble(this.powerTags.CurrentEnergy, this.powerConfig.maximalEnergy)
		tag.setDouble(this.powerTags.MaxEnergy, this.powerConfig.maximalEnergy)
		tag.setDouble(this.powerTags.ChargeMultiplier, this.powerConfig.maximalChargeMultiplier)
		tag.setDouble(this.powerTags.DischargePerTick, this.powerConfig.minimalDischargePerTick)

		tag.setDouble(this.armorTags.EnergyPerDamage, this.armorConfig.minimalEnergyPerDamage)
		tag.setDouble(this.armorTags.ArmorBase, this.armorConfig.maximalArmorBase)
		tag.setDouble(this.armorTags.AbsorptionRatio, this.armorConfig.maximalAbsorptionRatio)

		tag.setDouble(this.functionalityTags.StepHeight, this.functionalityConfig.maximalStepHeight)

		list.add(stack)
	}
}
