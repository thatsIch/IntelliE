package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.ItemStacks
import net.minecraft.item.crafting.ShapedRecipes

/**
 *
 *
 * @author thatsIch
 * @since 23.06.2014.
 */
class DissemblerRecipe( implicit stacks: ItemStacks )
	extends ShapedRecipes( 3, 3,
		Array(
			stacks.stoneStack, stacks.stoneStack, stacks.stoneStack,
			stacks.stoneStack, stacks.stoneStack, stacks.stoneStack,
			stacks.stoneStack, stacks.stoneStack, stacks.stoneStack
		), stacks.dissemblerStack )
