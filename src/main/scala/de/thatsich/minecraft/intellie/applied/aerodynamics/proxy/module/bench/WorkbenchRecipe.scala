package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench


import de.thatsich.minecraft.common.module.recipe.BaseRecipe
import de.thatsich.minecraft.common.string.{BaseConfigPath, BaseResourcePath}


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchRecipe extends BaseRecipe(new InternalWorkbenchRecipePath, new ExternalWorkbenchRecipePath)

private class InternalWorkbenchRecipePath extends BaseResourcePath("assets", "appaero", "recipes", "workbench.recipe")

private class ExternalWorkbenchRecipePath extends BaseConfigPath("config", "AppliedEnergistics2", "IntelliE", "Aero", "workbench.recipe")
