package de.thatsich.minecraft.intellie.applied.aerodynamics.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.common.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.fake.{FakeItem, FakeItemRegistry}


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
