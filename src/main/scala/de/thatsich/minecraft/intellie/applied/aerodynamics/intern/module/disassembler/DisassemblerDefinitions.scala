package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinition
import de.thatsich.minecraft.intellie.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 01.08.2014.
 */
class DisassemblerDefinitions(log: Log, modid: ID) extends BaseDefinition(
	items = Vector(
		new DisassemblerItem(modid, log),
		new CreativeDisassemblerItem(modid, log)
	),
	recipes = Vector(new DisassemblerCraftRecipe, new DisassemblerUpgradeRecipe)
) 