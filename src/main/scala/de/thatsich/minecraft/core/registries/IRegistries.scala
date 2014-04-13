package de.thatsich.minecraft.core.registries

import de.thatsich.minecraft.core.IEventProxy


/**
 * Representation of a collection of registries
 * Extends IEventProxy to allocate the calls
 * regarding to the event timings
 *
 * @author thatsIch
 * @since 08.04.2014.
 */
trait IRegistries
	extends IEventProxy
{
	def armorRenderers: ArmorRenderingRegistry

	def items: ItemRegistry
}
