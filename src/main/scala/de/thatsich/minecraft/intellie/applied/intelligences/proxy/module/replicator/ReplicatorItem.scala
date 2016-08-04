package de.thatsich.minecraft.intellie.applied.intelligences.proxy.module.replicator

import java.util

import appeng.api.config.AccessRestriction
import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.proxy.module.BaseItem
import de.thatsich.minecraft.common.proxy.module.item._
import de.thatsich.minecraft.common.util.nbt.NBTTags
import de.thatsich.minecraft.common.util.string.ModID
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}

/**
  * Created by thatsIch on 04.08.2016.
  */
private[replicator] class ReplicatorItem(modid: ModID, log: Log)
	extends BaseItem(new ReplicatorID, modid, log)
		with PoweredItemDamageDisplay
		with UnstackableItem
		with UniqueItem
		with AEHumanNumberFormat
		with NBTKeys
{
//	val config: Config = new DisassemblerConfig

//	val functionalityConfig: DisassemblerFunctionalityConfig = new DisassemblerFunctionalityConfigAccess(this.config)
//	val weaponConfig: DisassemblerWeaponConfig = new DisassemblerWeaponConfigAccess(this.config)
//	val powerStorageConfig: DisassemblerItemPowerStorageConfig = new DisassemblerItemPowerStorageConfigAccess(this.config)

//	val toolTags: ToolTags = new ToolTags(this.functionalityConfig)
//	val weaponTags: WeaponTags = new WeaponTags(this.weaponConfig)
//	val powerStorageTags: ItemPowerStorageTags = new ItemPowerStorageTags(this.powerStorageConfig)

	override def getNBTKeys: Seq[NBTTags] = Vector(/*this.toolTags, this.weaponTags, this.powerStorageTags*/)

	override def addInformation(is: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
//		val currentPower = this.getAECurrentPower(is).toInt
//		val maxPower = this.getAEMaxPower(is).toInt
//		val percent = if (maxPower == 0) 0 else 100 * (currentPower / maxPower)
//
//		val list = information.asInstanceOf[java.util.List[String]]
//
//		// add additional information when sneaking
//		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
//		{
//			val energyUsage = this.getCurrentEnergyUsage(is).toInt
//			val multiplier = this.getCurrentChargeMultiplier(is).toInt
//			val speed = this.getCurrentMiningSpeed(is)
//			val level = this.getCurrentMiningLevel(is)
//			val damage = this.getCurrentDamageVsEntities(is).toInt
//
//			list.add(s"Stored Energy: $currentPower/$maxPower AE - $percent%")
//			list.add(s"Energy Cost: $energyUsage")
//			list.add(s"Charge Multiplier: $multiplier")
//
//			list.add(s"Mining Speed: $speed")
//			list.add(s"Mining Level: $level")
//
//			list.add(s"Damage: $damage")
//		}
//		else
//		{
//			val shortCurrent = this.readableForm(currentPower)
//			list.add(s"Stored Energy: $shortCurrent - $percent%")
//			list.add("Hold shift for more information")
//		}
	}

	override def canHarvestBlock(block: Block, is: ItemStack): Boolean =
	{
//		val harvestLevel: Int = block.getHarvestLevel(0)
//		val currentMiningLevel: Double = this.getCurrentMiningLevel(is)
//
//		val currentEnergy = this.getAECurrentPower(is)
//		val energyUsage = this.getCurrentEnergyUsage(is)
//
//		currentMiningLevel >= harvestLevel && currentEnergy >= energyUsage
		true
	}

	@SideOnly(Side.CLIENT)
	override def getSubItems(item: Item, tabs: CreativeTabs, list: util.List[_]): Unit =
	{
//		super.getSubItems(item, tabs, list)
//
//		val stacks = list.asInstanceOf[util.List[ItemStack]]
//
//		val stack = new ItemStack(this)
//		val tag = this.getNBTData(stack)
//		tag.setDouble(this.powerStorageTags.CurrentEnergy.toString, this.powerStorageTags.CurrentEnergy.max)
//		tag.setDouble(this.powerStorageTags.MaxEnergy.toString, this.powerStorageTags.MaxEnergy.max)
//		tag.setInteger(this.powerStorageTags.ChargeMultiplier.toString, this.powerStorageTags.ChargeMultiplier.max)
//		tag.setDouble(this.powerStorageTags.EnergyCost.toString, this.powerStorageTags.EnergyCost.max)
//
//		tag.setDouble(this.weaponTags.Damage.toString, this.weaponTags.Damage.max)
//
//		tag.setInteger(this.toolTags.MiningLevel.toString, this.toolTags.MiningLevel.max)
//		tag.setInteger(this.toolTags.MiningSpeed.toString, this.toolTags.MiningSpeed.max)
//
//		stacks.add(stack)
	}

	override def getAECurrentPower(itemStack: ItemStack): Double = 0

	override def getPowerFlow(itemStack: ItemStack): AccessRestriction = AccessRestriction.READ_WRITE

	override def getAEMaxPower(itemStack: ItemStack): Double = 0

	override def extractAEPower(itemStack: ItemStack, v: Double): Double = 0

	override def injectAEPower(itemStack: ItemStack, v: Double): Double = 0
}

