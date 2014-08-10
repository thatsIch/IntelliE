package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import de.thatsich.minecraft.common.module.util.{CappedValue, NBTAccess}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, SharedMonsterAttributes}
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.DamageSource


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
trait Weapon extends Item
                     with NBTAccess
                     with DissemblerConfigAccess
                     with CappedValue
{
	private final val internalCurrentDamageVsEntities: String = "internalCurrentDamageVsEntities"

	override def onLeftClickEntity(stack: ItemStack, player: EntityPlayer, entity: Entity): Boolean =
	{
		var damage: Double = player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue

		damage += this.getCurrentDamageVsEntities(stack)

		entity.attackEntityFrom(DamageSource.causePlayerDamage(player), damage.toFloat)

		false
	}

	def getCurrentDamageVsEntities(is: ItemStack): Double =
	{
		val tag: NBTTagCompound = this.getNBTData(is)
		val current: Double = tag.getDouble(this.internalCurrentDamageVsEntities)

		this.getInBetween(this.initDamageVsEntites, current, this.maxDamageVsEntites)
	}

	def setCurrentDamageVsEntities(is: ItemStack, value: Double): Unit =
	{
		val tag: NBTTagCompound = this.getNBTData(is)
		tag.setDouble(this.internalCurrentDamageVsEntities, value)
	}
}
