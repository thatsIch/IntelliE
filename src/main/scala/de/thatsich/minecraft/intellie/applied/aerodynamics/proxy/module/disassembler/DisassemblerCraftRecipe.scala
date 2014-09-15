package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.disassembler.recipe.{ExternalDisassemblerCraftRecipePath, InternalDisassemblerCraftRecipePath}


/**
 *
 *
 * @author thatsIch
 * @since 23.06.2014.
 */
private[disassembler] class DisassemblerCraftRecipe extends BaseRecipe(new InternalDisassemblerCraftRecipePath, new ExternalDisassemblerCraftRecipePath)
