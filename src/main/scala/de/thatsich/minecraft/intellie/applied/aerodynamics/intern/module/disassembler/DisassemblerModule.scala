package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseModule
import de.thatsich.minecraft.common.string.id.ID


/**
 *
 *
 * @author thatsIch
 * @since 01.08.2014.
 */
class DisassemblerModule(log: Log, modid: ID) extends BaseModule(
	items = Vector(new DisassemblerItem(modid, log)),
	recipes = Vector(new DisassemblerCraftRecipe, new DisassemblerUpgradeRecipe)
)