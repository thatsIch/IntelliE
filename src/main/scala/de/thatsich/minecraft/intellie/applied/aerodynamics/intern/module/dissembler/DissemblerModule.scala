package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 01.08.2014.
 */
class DissemblerModule(log: Log, modid: ID, name: ID = new DissemblerID) extends BaseModule(
	items = List(new DissemblerItem(modid, name, log)),
	recipes = List(new DissemblerRecipe)
)