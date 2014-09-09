package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.recipe


import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.workbench.WorkbenchRecipe
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
class InternalWorkbenchRecipe
(
	val input: ItemStack,
	val upgrade: ItemStack,
	val modifier: String,
	val output: ItemStack,
	val energycost: Double,
	val time: Int)
	extends WorkbenchRecipe