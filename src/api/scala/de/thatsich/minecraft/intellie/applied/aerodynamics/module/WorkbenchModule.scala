package de.thatsich.minecraft.intellie.applied.aerodynamics.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.module.workbench.{WorkbenchRecipe, WorkbenchRegistry}
import de.thatsich.minecraft.intellie.common.Module
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait WorkbenchModule extends Module
{
	def createNewWorkbenchRecipe(input: ItemStack, upgrade: ItemStack, modifier: String, output: ItemStack, energycost: Double, time: Int): WorkbenchRecipe

	def registry: WorkbenchRegistry
}
