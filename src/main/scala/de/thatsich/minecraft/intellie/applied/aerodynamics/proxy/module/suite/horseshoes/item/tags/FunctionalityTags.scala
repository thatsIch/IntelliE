package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config.HorseShoesFunctionalityConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
class FunctionalityTags(config: HorseShoesFunctionalityConfig)
extends NBTTags
{
	override def values = Vector(StepHeight)

	object StepHeight extends BaseBoundNBTProperty[Double](this.config.minimalStepHeight, this.config.maximalStepHeight, 10)

}
