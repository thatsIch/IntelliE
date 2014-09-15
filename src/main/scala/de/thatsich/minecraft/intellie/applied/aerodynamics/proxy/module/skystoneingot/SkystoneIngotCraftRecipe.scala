package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.skystoneingot


import de.thatsich.minecraft.common.proxy.module.recipe.BaseRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.skystoneingot.recipe.{ExternalSkystoneIngotCraftRecipe, InternalSkystoneIngotCraftRecipe}


/**
 * 
 *
 * @author thatsIch
 * @since 11.09.2014.
 */
class SkystoneIngotCraftRecipe extends BaseRecipe(new InternalSkystoneIngotCraftRecipe, new ExternalSkystoneIngotCraftRecipe)