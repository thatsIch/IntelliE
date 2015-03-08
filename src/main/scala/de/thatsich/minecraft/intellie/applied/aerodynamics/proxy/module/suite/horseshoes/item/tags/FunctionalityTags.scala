package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.config.HorseShoesFunctionalityConfig


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
private[horseshoes]
class FunctionalityTags(config: HorseShoesFunctionalityConfig)
extends NBTTags
{
	override def values = Vector(ExtraStepHeight)

	object ExtraStepHeight extends BaseBoundNBTProperty[Double](this.config.minimalExtraStepHeight, this.config.maximalExtraStepHeight, 10)

}
