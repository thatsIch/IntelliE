package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.boots

import net.minecraftforge.common.ISpecialArmor
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraft.entity.player.EntityPlayer

/**
 *
 *
 * @author thatsIch
 * @since 16.04.2014.
 */
private[ boots ] trait TAeroBootsSpecialArmor extends ISpecialArmor
{
	self: ItemAeroBoots =>

	override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val absorptionRatio: Double = ItemAeroBoots.baseAbsorptionRatio * ItemAeroBoots.damageAbsorptionRatio
		val damageLimit: Int = if( ItemAeroBoots.energyPerDamage > 0 ) 25 * 100 / ItemAeroBoots.energyPerDamage else 0

		new ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit)
	}

	override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		Math.round(ItemAeroBoots.BASE_VALUE *
			ItemAeroBoots.baseAbsorptionRatio *
			ItemAeroBoots.damageAbsorptionRatio
		).toInt
	}

	override def damageArmor(entity: EntityLivingBase, stack: ItemStack, source: DamageSource, damage: Int, slot: Int)
	{
	}
}

