package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes


import java.util

import cpw.mods.fml.relauncher.{SideOnly, Side}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.item.{NBTKeys, PoweredItemDamageDisplay}
import de.thatsich.minecraft.common.util.nbt.NBTTags
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
// TODO convert config values to int and use a multiple of N instead using double cause stepheight 0.5 -> 1.0 is impossible with +1. Instead do 5 -> 10 and later divide through 10 but use int 5 - 10 internally
class HorseShoesItem(modid: ModID, log: Log)
extends BaseItemArmor(ArmorType.Boots, modid, new HorseShoesID, log)
        with HorseShoesItemPowerStorage
        with HorseShoesSpecialArmor
        with PoweredItemDamageDisplay
        with AEHumanNumberFormat
        with HorseShoesStepHeightLogic
        with NBTKeys
{
	val config = new HorseShoesConfig

	val armorConfig = new HorseShoesArmorConfigAccess(this.config)
	val functionalityConfig = new HorseShoesFunctionalityConfigAccess(this.config)
	val powerConfig = new HorseShoesItemPowerStorageConfigAccess(this.config)

	val armorTags = new ArmorTags(this.armorConfig)
	val functionalityTags = new FunctionalityTags(this.functionalityConfig)
	val powerTags = new ItemPowerStorageTags(this.powerConfig)

	override def getNBTKeys: Seq[NBTTags] = Vector(this.armorTags, this.functionalityTags, this.powerTags)

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
			list.add(s"Charge Multiplier: ${this.getCurrentChargeMultiplier(is)}")
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

	@SideOnly(Side.CLIENT)
	override def getSubItems(item: Item, tabs: CreativeTabs, itemstacks: util.List[_]): Unit =
	{
		super.getSubItems(item, tabs, itemstacks)

		val list = itemstacks.asInstanceOf[util.List[ItemStack]]

		val stack = new ItemStack(this)
		val tag = this.getNBTData(stack)
		tag.setDouble(this.powerTags.CurrentEnergy.toString, this.powerTags.CurrentEnergy.max)
		tag.setDouble(this.powerTags.MaxEnergy.toString, this.powerTags.MaxEnergy.max)
		tag.setInteger(this.powerTags.ChargeMultiplier.toString, this.powerTags.ChargeMultiplier.max)
		tag.setDouble(this.powerTags.DischargePerTick.toString, this.powerTags.DischargePerTick.min)

		tag.setDouble(this.armorTags.EnergyPerDamage.toString, this.armorTags.EnergyPerDamage.min)
		tag.setInteger(this.armorTags.ArmorBase.toString, this.armorTags.ArmorBase.max)
		tag.setDouble(this.armorTags.AbsorptionRatio.toString, this.armorTags.AbsorptionRatio.max)

		tag.setDouble(this.functionalityTags.StepHeight.toString, this.functionalityTags.StepHeight.max)

		list.add(stack)
	}
}
