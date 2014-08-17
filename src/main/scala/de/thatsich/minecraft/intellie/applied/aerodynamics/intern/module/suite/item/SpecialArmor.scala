package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.common.ISpecialArmor
import net.minecraftforge.common.ISpecialArmor.ArmorProperties


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
trait SpecialArmor extends ISpecialArmor
{
	def getProperties(player: EntityLivingBase, armor: ItemStack, source: DamageSource, damage: Double, slot: Int): ArmorProperties = ???

	def damageArmor(entity: EntityLivingBase, stack: ItemStack, source: DamageSource, damage: Int, slot: Int): Unit = ???

	def getArmorDisplay(player: EntityPlayer, armor: ItemStack, slot: Int): Int = ???
}
