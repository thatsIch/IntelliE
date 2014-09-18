package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.common.item.config.ArmorConfig


/**
 * 
 *
 * @author thatsIch
 * @since 17.09.2014.
 */
private[suite] class ArmorTags(config: ArmorConfig) extends NBTTags
{
	object EnergyPerDamage extends BaseBoundNBTProperty[Double](this.config.minimalEnergyPerDamage, this.config.maximalEnergyPerDamage)
	object AbsorptionRatio extends BaseBoundNBTProperty[Double](this.config.minimalAbsorptionRatio, this.config.maximalAbsorptionRatio, 100)
	object ArmorBase extends BaseBoundNBTProperty[Int](this.config.minimalArmorBase, this.config.maximalArmorBase)

	override def values = Vector(EnergyPerDamage, AbsorptionRatio, ArmorBase)
}
