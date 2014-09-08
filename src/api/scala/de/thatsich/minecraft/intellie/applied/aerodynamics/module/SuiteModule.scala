package de.thatsich.minecraft.intellie.applied.aerodynamics.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.common.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.suite.{SkyDiverModule, HorseShoesModule, ChestNutModule, FreeRunnerModule}


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
