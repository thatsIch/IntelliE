package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite


import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.skydiver.SkyDiverDefinitions


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
class InternalSkydiverModule(modid: ModID, log: Log) extends SkyDiverModule
{
	override lazy val definitions: Definitions = new SkyDiverDefinitions(this.modid, this.log)
}
