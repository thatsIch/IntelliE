package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.{ChestNutModule, FreeRunnerModule, HorseShoesModule, InternalChestNutModule, InternalFreeRunnerModule, InternalHorseShoesModule, InternalSkydiverModule, SkyDiverModule, SuiteDefinitions}


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class InternalSuiteModule(modid: ModID, log: Log) extends SuiteModule
{
	override lazy val horseshoes: HorseShoesModule = new InternalHorseShoesModule(this.modid, this.log)

	override lazy val skydiver: SkyDiverModule = new InternalSkydiverModule(this.modid, this.log)

	override lazy val freerunner: FreeRunnerModule = new InternalFreeRunnerModule(this.modid, this.log)

	override lazy val chestnut: ChestNutModule = new InternalChestNutModule(this.modid, this.log)

	override lazy val definitions: Definitions = new SuiteDefinitions(this.modid, this.log)
}
