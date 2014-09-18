package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite


import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ModID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.chestnut.ChestNutDefinitions


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
class InternalChestNutModule(modid: ModID, log: Log) extends ChestNutModule
{
	override lazy val definitions: Definitions = new ChestNutDefinitions(this.modid, this.log)
}