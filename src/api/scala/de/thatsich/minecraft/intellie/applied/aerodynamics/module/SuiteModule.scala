package de.thatsich.minecraft.intellie.applied.aerodynamics.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.module.suite.{SkyDiverModule, HorseShoesModule, ChestNutModule, FreeRunnerModule}
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
