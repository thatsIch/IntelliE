package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ID


/**
 *
 *
 * @author thatsIch
 * @since 01.08.2014.
 */
class DisassemblerDefinitions(modid: ID, log: Log) extends BaseDefinitions(
	items = Vector(
		new DisassemblerItem(modid, log),
		new CreativeDisassemblerItem(modid, log)
	),
	recipes = Vector(new DisassemblerCraftRecipe, new DisassemblerUpgradeRecipe)
) 