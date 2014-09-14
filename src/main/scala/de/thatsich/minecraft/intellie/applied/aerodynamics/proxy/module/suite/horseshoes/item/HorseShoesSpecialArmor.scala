package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item


import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import de.thatsich.minecraft.common.util.BoundDetection
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags.ArmorTags
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.common.ISpecialArmor

import scala.language.implicitConversions


/**
 *
 *
 * @author thatsIch
 * @since 02.09.2014.
 */
trait HorseShoesSpecialArmor
extends ISpecialArmor
        with HorseShoesItemPowerStorage
        with NBTKeyStorage
        with BoundDetection
{
	def armorTags: ArmorTags

	override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val damageLimit: Int = (25 * 100 / this.getEnergyPerDamage(armor)).toInt

		new ISpecialArmor.ArmorProperties(0, this.getAbsorptionRatio(armor), damageLimit)
	}

	override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		Math.round(this.getArmorBase(armor) * this.getAbsorptionRatio(armor)).toInt
	}

	override def damageArmor(entity: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Int, slot: Int): Unit =
	{
		this.extractAEPower(armor, damage * this.getEnergyPerDamage(armor))
	}

	def getAbsorptionRatio(armor: ItemStack): Double = this.withinBounds(armor, this.armorTags.AbsorptionRatio)

	def getEnergyPerDamage(armor: ItemStack): Double = this.withinReversedBounds(armor, this.armorTags.EnergyPerDamage)

	def getArmorBase(armor: ItemStack): Double = this.withinBounds(armor, this.armorTags.ArmorBase)
}
