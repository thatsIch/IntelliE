package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.client


import de.thatsich.minecraft.common.module.container.BaseSlot


/**
 *
 *
 * @author thatsIch
 * @since 29.08.2014.
 */
trait HoloSlot extends BaseSlot
{
	val holoSlotOffsetX: Int

	val holoSlotOffsetY: Int

	val textureNamespace: String

	val texturePath: String
}
