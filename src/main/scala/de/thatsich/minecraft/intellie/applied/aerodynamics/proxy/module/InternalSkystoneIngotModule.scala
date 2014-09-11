package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.skystoneingot.SkystoneIngotDefinitions


/**
 * 
 *
 * @author thatsIch
 * @since 11.09.2014.
 */
class InternalSkystoneIngotModule(modid: ModID, log: Log) extends SkystoneIngotModule
{
	override def definitions: Definitions = new SkystoneIngotDefinitions(this.modid, this.log)
}
