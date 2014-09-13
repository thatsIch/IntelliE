package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.tags


import de.thatsich.minecraft.common.util.nbt.{BaseBoundNBTProperty, BoundNBTProperty, NBTTags}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.HorseShoesConfigAccess


/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
object LogicTags extends NBTTags with HorseShoesConfigAccess
{
	object StepHeight extends BaseBoundNBTProperty(this.initStepHeight, this.maxStepHeight)

	override def values: Seq[BoundNBTProperty] = Vector(StepHeight)
}
