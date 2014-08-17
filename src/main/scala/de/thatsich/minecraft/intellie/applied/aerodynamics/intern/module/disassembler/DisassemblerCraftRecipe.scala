package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler


import de.thatsich.minecraft.common.module.recipe.BaseRecipe
import de.thatsich.minecraft.common.string.{BaseConfigPath, BaseResourcePath}


/**
 *
 *
 * @author thatsIch
 * @since 23.06.2014.
 */
private[disassembler] class DisassemblerCraftRecipe extends BaseRecipe(new InternalDisassemblerCraftRecipePath, new ExternalDisassemblerCraftRecipePath)

private class ExternalDisassemblerCraftRecipePath extends BaseConfigPath("config", "AppliedEnergistics2", "IntelliE", "Aero", "disassembler.recipe")

private class InternalDisassemblerCraftRecipePath extends BaseResourcePath("assets", "appaero", "recipes", "disassembler.recipe")
