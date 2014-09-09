package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.SkyDiverDefinitions
import de.thatsich.minecraft.intellie.common.Definitions
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
class InternalSkydiverModule(modid: ID, log: Log) extends SkyDiverModule
{
	override lazy val definitions: Definitions = new SkyDiverDefinitions(this.modid, this.log)
}
