package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.dissembler

import de.thatsich.minecraft.intellie.applied.aerodynamics.common.ItemStacks
import net.minecraft.item.crafting.ShapedRecipes

object RecipeDissembler extends RecipeDissembler

/**
 *
 *
 * @author thatsIch
 * @since 23.06.2014.
 */
class RecipeDissembler( implicit stacks: ItemStacks ) extends ShapedRecipes( 3, 3,
	Array( stacks.stoneStack, stacks.stoneStack, stacks.stoneStack, stacks.stoneStack, stacks.stoneStack, stacks.stoneStack, stacks.stoneStack, stacks.stoneStack, stacks.stoneStack ), stacks.dissemblerStack )
{

}

