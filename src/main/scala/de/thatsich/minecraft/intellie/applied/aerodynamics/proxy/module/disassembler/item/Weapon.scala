package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.item


import de.thatsich.minecraft.common.module.BaseItem
import de.thatsich.minecraft.common.module.util.NBTAccess
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.DamageSource


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait Weapon extends BaseItem
                     with NBTAccess
                     with DisassemblerConfigAccess
                     with PoweredItem
{
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

	def getCurrentDamageVsEntities(is: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(is)
		val current: Double = tag.getDouble(Tags.Damage)

		(this.initDamageVsEntites + current) min this.maxDamageVsEntites
	}

	def setCurrentDamageVsEntities(is: ItemStack, value: Double): Unit =
	{
		val tag: NBTTagCompound = this.getNBTData(is)
		tag.setDouble(Tags.Damage, value)
	}

	private object Tags extends BaseNBTProperty
	{
		val Damage = Value
	}

}