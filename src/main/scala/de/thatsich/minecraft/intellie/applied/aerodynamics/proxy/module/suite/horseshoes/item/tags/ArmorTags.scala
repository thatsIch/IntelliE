package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config.HorseShoesArmorConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class ArmorTags (config: HorseShoesArmorConfig) extends NBTTags
{
	object EnergyPerDamage extends BaseBoundNBTProperty(this.config.minimalEnergyPerDamage, this.config.maximalEnergyPerDamage)
	object AbsorptionRatio extends BaseBoundNBTProperty(this.config.minimalAbsorptionRatio, this.config.maximalAbsorptionRatio)
	object ArmorBase extends BaseBoundNBTProperty(this.config.minimalArmorBase, this.config.maximalArmorBase)

	override def values: Seq[BoundNBTProperty] = Vector(EnergyPerDamage, AbsorptionRatio, ArmorBase)
}
