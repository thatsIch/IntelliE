package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.freerunner.FreeRunnerDefinitions
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.suite.FreeRunnerModule
import de.thatsich.minecraft.intellie.common.Definitions
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
class InternalFreeRunnerModule(modid: ID, log: Log) extends FreeRunnerModule
{
	override lazy val definitions: Definitions = new FreeRunnerDefinitions(this.modid, this.log)
}
