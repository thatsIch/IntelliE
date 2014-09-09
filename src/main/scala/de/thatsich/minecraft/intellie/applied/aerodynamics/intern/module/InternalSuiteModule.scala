package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.{InternalChestNutModule, InternalFreeRunnerModule, SuiteDefinitions, InternalHorseShoesModule, InternalSkydiverModule}
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.SuiteModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.suite.{ChestNutModule, FreeRunnerModule, HorseShoesModule, SkyDiverModule}
import de.thatsich.minecraft.intellie.common.Definitions
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class InternalSuiteModule(modid: ID, log: Log) extends SuiteModule
{
	override lazy val horseshoes: HorseShoesModule = new InternalHorseShoesModule(this.modid, this.log)

	override lazy val skydiver: SkyDiverModule = new InternalSkydiverModule(this.modid, this.log)

	override lazy val freerunner: FreeRunnerModule = new InternalFreeRunnerModule(this.modid, this.log)

	override lazy val chestnut: ChestNutModule = new InternalChestNutModule(this.modid, this.log)

	override lazy val definitions: Definitions = new SuiteDefinitions(this.modid, this.log)
}
