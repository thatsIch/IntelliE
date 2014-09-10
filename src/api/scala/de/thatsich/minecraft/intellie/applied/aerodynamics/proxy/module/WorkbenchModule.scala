package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.common.Module
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.workbench.{WorkbenchRecipe, WorkbenchRegistry}
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