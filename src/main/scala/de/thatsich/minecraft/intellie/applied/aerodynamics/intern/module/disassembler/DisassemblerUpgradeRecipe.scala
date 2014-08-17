package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.disassembler


import de.thatsich.minecraft.common.module.recipe.BaseRecipe
import de.thatsich.minecraft.common.string.{BaseConfigPath, BaseResourcePath}


/**
 *
 *
 * @author thatsIch
 * @since 14.08.2014.
 */
class DisassemblerUpgradeRecipe extends BaseRecipe(new InternalDisassemblerUpgradeRecipePath, new ExternalDisassemblerUpgradeRecipePath)

private class InternalDisassemblerUpgradeRecipePath extends BaseResourcePath("assets", "appaero", "recipes", "disassembler.upgrade")

private class ExternalDisassemblerUpgradeRecipePath extends BaseConfigPath("config", "AppliedEnergistics2", "IntelliE", "Aero", "disassembler.upgrade")
