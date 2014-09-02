package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.item


import de.thatsich.minecraft.common.module.util.NBTAccess
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.DamageSource
import net.minecraftforge.common.ISpecialArmor


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
trait HorseShoesSpecialArmor extends ISpecialArmor
	with HorseShoesItemPowerStorage
	with NBTAccess
{
	val config = new HorseShoesConfigAccess

	def getEnergyPerDamage(armor: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(armor)
		val current: Double = tag.getDouble(Tags.EnergyPerDamage)
		val min: Double = this.config.minEnergyPerDamagePoint
		val max: Double = this.config.initEnergyPerDamagePoint

		min max (current min max)
	}

	def getAborptionRatio(armor: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(armor)
		val current: Double = tag.getDouble(Tags.AborptionRatio)
		val min: Double = this.config.initAbsorptionRatio
		val max: Double = this.config.maxAbsorptionRatio

		min max (current min max)
	}

	def getArmorBase(armor: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(armor)
		val current: Double = tag.getDouble(Tags.DamageBase)
		val min: Double = this.config.initArmorBase
		val max: Double = this.config.maxArmorBase

		min max (current min max)
	}

	override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val damageLimit: Int = (25 * 100 / this.getEnergyPerDamage(armor)).toInt

		new ISpecialArmor.ArmorProperties(0, this.getAborptionRatio(armor), damageLimit)
	}

	override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		Math.round(this.getArmorBase(armor) * this.getAborptionRatio(armor)).toInt
	}

	override def damageArmor(entity: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Int, slot: Int): Unit =
	{
		this.extractAEPower(armor, damage * this.getEnergyPerDamage(armor))
	}

	private object Tags extends Enumeration
	{
		type Tags = Value
		val EnergyPerDamage, AborptionRatio, DamageBase = Value

		implicit def tagsToString(tag: Tags): String = tag.toString.toLowerCase
	}
}
