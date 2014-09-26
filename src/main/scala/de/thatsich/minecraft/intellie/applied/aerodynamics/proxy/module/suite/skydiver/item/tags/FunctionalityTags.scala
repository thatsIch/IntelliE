package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.item.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.item.config.SkyDiverFunctionalityConfig


/**
 * 
 *
 * @author thatsIch
 * @since 20.09.2014.
 */
private[skydiver]
class FunctionalityTags(config: SkyDiverFunctionalityConfig)
extends NBTTags
{
	override def values = Vector(Breathing)

	object Breathing extends BaseBoundNBTProperty[Int](this.config.minimalBreathing, this.config.maximalBreathing)

}
