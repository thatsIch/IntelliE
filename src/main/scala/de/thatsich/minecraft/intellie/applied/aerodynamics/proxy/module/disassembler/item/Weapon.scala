package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import de.thatsich.minecraft.common.module.BaseItem
import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import de.thatsich.minecraft.common.module.util.NBTAccess
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.tags.WeaponTags
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait Weapon extends BaseItem
                     with NBTAccess
                     with PoweredItem
                     with NBTKeyStorage
{
	def weapontags: WeaponTags

	/**
	 * Called when hitting an entity
	 * if sufficient power is there
	 * it deals damage to the target
	 *
	 * @param is weapoen
	 * @param target target entity
	 * @param hitter hitting entity
	 *
	 * @return false to cancel further processing
	 */
	override def onLeftClickEntity(is: ItemStack, hitter: EntityPlayer, target: Entity): Boolean =
	{
		val energyUsage = this.getCurrentEnergyUsage(is)
		if (this.getAECurrentPower(is) >= energyUsage)
		{
			val source = DamageSource.causePlayerDamage(hitter)
			val damage: Float = this.getCurrentDamageVsEntities(is).toFloat

			if (damage > 0)
			{
				this.extractAEPower(is, energyUsage)
				target.attackEntityFrom(source, damage)

				return true
			}
		}

		false
	}

	def getCurrentDamageVsEntities(is: ItemStack): Double = this.withinBounds(is, this.weapontags.Damage)

	def setCurrentDamageVsEntities(is: ItemStack, value: Double): Unit = this.getNBTData(is).setDouble(this.weapontags.Damage, value)
}