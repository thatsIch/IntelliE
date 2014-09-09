package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.horseshoes.HorseShoesDefinitions
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.suite.HorseShoesModule
import de.thatsich.minecraft.intellie.common.Definitions
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class InternalHorseShoesModule(modid: ID, log: Log) extends HorseShoesModule
{
	override def definitions: Definitions = new HorseShoesDefinitions(modid, log)
}
