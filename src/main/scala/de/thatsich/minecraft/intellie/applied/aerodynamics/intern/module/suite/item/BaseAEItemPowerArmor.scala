package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemArmor, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 17.04.2014.
 */
abstract class BaseAEItemPowerArmor(protected val maxStorage: Double, armorType: Int)
	extends ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, armorType)
	        with SpecialArmor
	        with AEItemPowerStorage
{
	final val steps = 32
	this.setMaxDamage(this.steps)
	this.hasSubtypes = false

	override def isRepairable: Boolean = false

	override def isDamageable: Boolean = true

	override def isDamaged(stack: ItemStack): Boolean = true

	override def addInformation(itemStack: ItemStack, player: EntityPlayer, information: java.util.List[_], advToolTips: Boolean) =
	{
		val currentPower = this.getAECurrentPower(itemStack)
		val maxPower = this.getAEMaxPower(itemStack)

		val percent = (currentPower / maxPower * 100).toInt
		// TODO format scala int to whole number without 10^x

		val message = s"Stored Energy: $currentPower AE - $percent%"

		val list = information.asInstanceOf[java.util.List[String]]
		list.add(message)
	}

	override def getDisplayDamage(stack: ItemStack): Int =
	{
		val percent = this.getAECurrentPower(stack) / this.getAEMaxPower(stack)
		val damage = this.steps - (this.steps * percent).toInt

		damage
	}
}
