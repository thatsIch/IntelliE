package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.freerunner.item.config.FreeRunnerFunctionalityConfig


/**
 * 
 *
 * @author thatsIch
 * @since 18.09.2014.
 */
private[freerunner]
class FreeRunnerFunctionalityTags(config: FreeRunnerFunctionalityConfig)
extends NBTTags
{
	override def values: Seq[BoundNBTProperty[_ <: AnyVal]] = Vector(WalkSpeed, RunSpeed)

	object WalkSpeed extends BaseBoundNBTProperty[Double](this.config.minimalWalkSpeed, this.config.maximalWalkSpeed, 100)

	object RunSpeed extends BaseBoundNBTProperty[Double](this.config.minimalRunSpeed, this.config.maximalRunSpeed, 100)

}
