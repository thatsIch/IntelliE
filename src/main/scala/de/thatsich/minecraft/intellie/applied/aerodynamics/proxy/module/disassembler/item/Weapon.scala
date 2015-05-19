package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import de.thatsich.minecraft.common.proxy.module.BaseItem
import de.thatsich.minecraft.common.proxy.module.util.NBTAccess
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
                     with DisassemblerItemPowerStorage
{
	def weaponTags: WeaponTags

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
			val damage: Double = this.getCurrentDamageVsEntities(is)

			if (damage > 0)
			{
				this.extractAEPower(is, energyUsage)
				target.attackEntityFrom(source, damage.toFloat)

				return true
			}
		}

		false
	}

	def getCurrentDamageVsEntities(is: ItemStack): Double = this.withinBounds(is, this.weaponTags.Damage)
}