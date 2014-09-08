package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Definitions
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.common.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.HorseShoesDefinition


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class HorseShoesModule(modid: ID, log: Log) extends Module
{
	override def definitions: Definitions = new HorseShoesDefinition(modid, log)
}
