package de.thatsich.minecraft.intellie.applied.aerodynamics.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.common.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.workbench.{WorkbenchRecipe, WorkbenchRegistry}
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
trait WorkbenchModule extends Module
{
	def createNewWorkbenchRecipe(input: ItemStack, upgrade: ItemStack, modifier: String, energycost: Double, time: Int): WorkbenchRecipe

	def registry: WorkbenchRegistry
}
