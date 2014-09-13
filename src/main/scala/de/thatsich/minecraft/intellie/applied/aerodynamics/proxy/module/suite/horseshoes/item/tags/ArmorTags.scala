package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags


import de.thatsich.minecraft.common.util.nbt.{BoundNBTProperty, NBTTags, BaseBoundNBTProperty}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.HorseShoesConfigAccess


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
object ArmorTags extends NBTTags with HorseShoesConfigAccess
{
	object EnergyPerDamage extends BaseBoundNBTProperty(this.minEnergyPerDamagePoint, this.initEnergyPerDamagePoint)
	object AbsorptionRatio extends BaseBoundNBTProperty(this.initAbsorptionRatio, this.maxAbsorptionRatio)
	object ArmorBase extends BaseBoundNBTProperty(this.initArmorBase, this.maxArmorBase)

	override def values: Seq[BoundNBTProperty] = Vector(EnergyPerDamage, AbsorptionRatio, ArmorBase)
}
