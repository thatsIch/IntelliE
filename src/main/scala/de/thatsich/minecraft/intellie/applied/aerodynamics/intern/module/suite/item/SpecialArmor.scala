package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import appeng.api.implementations.items.IAEItemPowerStorage
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.common.ISpecialArmor


/**
 * Special Armor handling with damaging and displaying armor
 *
 * @author thatsIch
 * @since 17.04.2014.
 */
private[item] trait SpecialArmor extends IAEItemPowerStorage with ISpecialArmor
{
	final val energyPerDamage: Double = 1000D
	final val absorptionRatio: Double = 0.44D
	final val damageBase: Double = 20D

	override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val damageLimit: Int = (25 * 100 / this.energyPerDamage).toInt

		new ISpecialArmor.ArmorProperties(0, this.absorptionRatio, damageLimit)
	}

	override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		Math.round(this.damageBase * this.absorptionRatio).toInt
	}

	override def damageArmor(entity: EntityLivingBase, stack: ItemStack, source: DamageSource, damage: Int, slot: Int): Unit =
	{
		this.extractAEPower(stack, damage * this.energyPerDamage)
	}
}
