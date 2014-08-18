package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.fakeupgrade


import codechicken.nei.api.IConfigureNEI


/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
class FakeNEIDisabler extends IConfigureNEI
{
	def loadConfig(): Unit = {
		println("TEST?!?")
	}

	def getName: String = "appaero"

	def getVersion: String = "1"
}
