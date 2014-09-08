package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.boots.HorseShoesDefinition
import de.thatsich.minecraft.intellie.common.util.string.ID
import de.thatsich.minecraft.intellie.common.{Definitions, Module}


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
