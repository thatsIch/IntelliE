package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module


import de.thatsich.minecraft.intellie.applied.aerodynamics.module.WorkbenchModule
import de.thatsich.minecraft.intellie.applied.aerodynamics.module.workbench.{WorkbenchRecipe, WorkbenchRegistry}
import de.thatsich.minecraft.intellie.common.Definitions
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class InternalWorkbenchModule extends WorkbenchModule
{
	override def createNewWorkbenchRecipe(input: ItemStack, upgrade: ItemStack, modifier: String, energycost: Double, time: Int): WorkbenchRecipe = ???

	override def registry: WorkbenchRegistry = ???

	override def definitions: Definitions = ???
}
