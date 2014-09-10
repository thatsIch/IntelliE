package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite


import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.HorseShoesDefinitions


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
