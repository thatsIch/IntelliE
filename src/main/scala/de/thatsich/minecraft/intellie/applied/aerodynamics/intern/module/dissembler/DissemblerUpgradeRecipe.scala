package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler


import de.thatsich.minecraft.common.module.recipe.BaseRecipe
import de.thatsich.minecraft.common.string.{BaseConfigPath, BaseResourcePath}


/**
 *
 *
 * @author thatsIch
 * @since 14.08.2014.
 */
class DissemblerUpgradeRecipe extends BaseRecipe(new InternalDissemblerUpgradePath, new ExternalDissemblerUpgradePath)

private class InternalDissemblerUpgradePath extends BaseResourcePath("assets", "appaero", "recipes", "dissembler.upgrade")

private class ExternalDissemblerUpgradePath extends BaseConfigPath("config", "AppliedEnergistics2", "IntelliE", "Aero", "dissembler.upgrade")
