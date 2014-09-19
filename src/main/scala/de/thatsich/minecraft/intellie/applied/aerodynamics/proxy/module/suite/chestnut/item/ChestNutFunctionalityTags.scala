package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.item.config.ChestNutFunctionalityConfig


/**
 * 
 *
 * @author thatsIch
 * @since 19.09.2014.
 */
private[chestnut]
class ChestNutFunctionalityTags(config: ChestNutFunctionalityConfig)
extends NBTTags
{
	override def values: Seq[BoundNBTProperty[_ <: AnyVal]] = Vector(FlySpeed)

	object FlySpeed extends BaseBoundNBTProperty[Double](this.config.minimalFlySpeed, this.config.maximalFlySpeed, 100)
}
