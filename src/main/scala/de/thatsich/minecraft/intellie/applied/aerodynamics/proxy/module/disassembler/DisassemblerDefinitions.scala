package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.BaseDefinitions
import de.thatsich.minecraft.common.util.string.ModID


/**
 *
 *
 * @author thatsIch
 * @since 01.08.2014.
 */
class DisassemblerDefinitions(modid: ModID, log: Log) extends BaseDefinitions(
	items = Vector(new DisassemblerItem(modid, log)),
	recipes = Vector(new DisassemblerCraftRecipe, new DisassemblerUpgradeRecipe)
) 