package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.{ChestNutModule, FreeRunnerModule, HorseShoesModule, SkyDiverModule}
import de.thatsich.minecraft.intellie.common.Module


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait SuiteModule extends Module
{
	def skydiver: SkyDiverModule

	def chestnut: ChestNutModule

	def freerunner: FreeRunnerModule

	def horseshoes: HorseShoesModule
}