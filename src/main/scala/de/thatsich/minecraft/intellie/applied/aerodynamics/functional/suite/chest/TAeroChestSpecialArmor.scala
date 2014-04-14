package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.suite.chest

import net.minecraftforge.common.ISpecialArmor
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraft.entity.player.EntityPlayer

/**
 *
 *
 * @author thatsIch
 * @since 14.04.2014.
 */
trait TAeroChestSpecialArmor extends ISpecialArmor
{
	override def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ISpecialArmor.ArmorProperties =
	{
		val absorptionRatio: Double = ItemAeroChest.baseAbsorptionRatio * ItemAeroChest.damageAbsorptionRatio
		val damageLimit: Int = if( ItemAeroChest.energyPerDamage > 0 ) 25 * 100 / ItemAeroChest.energyPerDamage else 0

		new ISpecialArmor.ArmorProperties(0, absorptionRatio, damageLimit)
	}

	override def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int =
	{
		Math.round(ItemAeroChest.BASE_VALUE *
			ItemAeroChest.baseAbsorptionRatio *
			ItemAeroChest.damageAbsorptionRatio
		).toInt
	}

	override def damageArmor(entity: EntityLivingBase, stack: ItemStack, source: DamageSource, damage: Int, slot: Int)
	{
	}
}
