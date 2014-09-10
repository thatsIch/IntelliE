package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.common.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.fake.{FakeItem, FakeItemRegistry}


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