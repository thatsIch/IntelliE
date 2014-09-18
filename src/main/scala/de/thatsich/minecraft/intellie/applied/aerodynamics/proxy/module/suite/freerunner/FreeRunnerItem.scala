package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner


import java.util

import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.item.{NBTKeys, PoweredItemDamageDisplay}
import de.thatsich.minecraft.common.util.nbt.NBTTags
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item.AEHumanNumberFormat
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item.{ArmorType, BaseItemArmor}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.tags.{ArmorPowerTags, ArmorTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.{ArmorPower, SpecialArmor}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.config.{FreeRunnerArmorConfigAccess, FreeRunnerFunctionalityConfigAccess, FreeRunnerPowerConfigAccess}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.{FreeRunnerConfig, FreeRunnerFunctionalityTags, FreeRunnerMovementLogic}
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
private[freerunner] class FreeRunnerItem(modid: ModID, log: Log)
extends BaseItemArmor(ArmorType.Legs, modid, new FreeRunnerID, log)
        with ArmorPower
        with SpecialArmor
        with PoweredItemDamageDisplay
        with AEHumanNumberFormat
        with NBTKeys
        with FreeRunnerMovementLogic
{
	val config = new FreeRunnerConfig

	val armorConfig = new FreeRunnerArmorConfigAccess(this.config)
	val powerConfig = new FreeRunnerPowerConfigAccess(this.config)
	val funcConfig = new FreeRunnerFunctionalityConfigAccess(this.config)

	val armorTags = new ArmorTags(this.armorConfig)
	val powerTags = new ArmorPowerTags(this.powerConfig)
	val funcTags = new FreeRunnerFunctionalityTags(this.funcConfig)

	override def getNBTKeys: Seq[NBTTags] = Vector(this.armorTags, this.powerTags, this.funcTags)

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
			list.add(s"Walkspeed: ${this.getWalkSpeed(is)}")
			list.add(s"Runspeed: ${this.getRunSpeed(is)}")
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
		tag.setDouble(this.powerTags.DischargePerTick.toString, this.powerTags.DischargePerTick.max)

		tag.setDouble(this.armorTags.EnergyPerDamage.toString, this.armorTags.EnergyPerDamage.max)
		tag.setInteger(this.armorTags.ArmorBase.toString, this.armorTags.ArmorBase.max)
		tag.setDouble(this.armorTags.AbsorptionRatio.toString, this.armorTags.AbsorptionRatio.max)

		tag.setFloat(this.funcTags.WalkSpeed.toString, this.funcTags.WalkSpeed.max)
		tag.setFloat(this.funcTags.RunSpeed.toString, this.funcTags.RunSpeed.max)

		list.add(stack)
	}
}
