package de.thatsich.minecraft.intellie.applied.aerodynamics.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.module.fake.{FakeItem, FakeItemRegistry}
import de.thatsich.minecraft.intellie.common.Module


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
trait FakeModule extends Module
{
	def addFakeItem(fakeid: String): FakeItem

	def registry: FakeItemRegistry
}
