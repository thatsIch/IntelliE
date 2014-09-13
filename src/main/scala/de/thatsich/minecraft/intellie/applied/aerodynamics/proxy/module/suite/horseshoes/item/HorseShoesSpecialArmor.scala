package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item


import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import de.thatsich.minecraft.common.module.util.NBTAccess
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.DamageSource
import net.minecraftforge.common.ISpecialArmor

import scala.language.implicitConversions


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
trait HorseShoesSpecialArmor extends ISpecialArmor
                                     with HorseShoesItemPowerStorage
                                     with NBTAccess
                                     with NBTKeyStorage
                                     with HorseShoesConfigAccess
{
	override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val damageLimit: Int = (25 * 100 / this.getEnergyPerDamage(armor)).toInt

		new ISpecialArmor.ArmorProperties(0, this.getAbsorptionRatio(armor), damageLimit)
	}

	def getAbsorptionRatio(armor: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(armor)
		val current: Double = tag.getDouble(Tags.AbsorptionRatio)
		val min: Double = this.initAbsorptionRatio
		val max: Double = this.maxAbsorptionRatio

		min max (current min max)
	}

	override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		Math.round(this.getArmorBase(armor) * this.getAbsorptionRatio(armor)).toInt
	}

	def getArmorBase(armor: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(armor)
		val current: Double = tag.getDouble(Tags.ArmorBase)
		val min: Double = this.initArmorBase
		val max: Double = this.maxArmorBase

		min max (current min max)
	}

	override def damageArmor(entity: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Int, slot: Int): Unit =
	{
		this.extractAEPower(armor, damage * this.getEnergyPerDamage(armor))
	}

	def getEnergyPerDamage(armor: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(armor)
		val current: Double = tag.getDouble(Tags.EnergyPerDamage)
		val min: Double = this.minEnergyPerDamagePoint
		val max: Double = this.initEnergyPerDamagePoint

		min max (current min max)
	}

	private object Tags extends BaseNBTProperty
	{
		val EnergyPerDamage, AbsorptionRatio, ArmorBase = Value
	}

	this.addNBTs(Tags)
}
