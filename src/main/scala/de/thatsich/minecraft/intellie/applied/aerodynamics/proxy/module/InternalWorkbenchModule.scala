package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module


import de.thatsich.minecraft.common.Definitions
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.WorkbenchDefinitions
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.recipe.{InternalWorkbenchRecipe, InternalWorkbenchRegistry}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.workbench.{WorkbenchRecipe, WorkbenchRegistry}
import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 08.09.2014.
 */
class InternalWorkbenchModule(modid: ID, log: Log) extends WorkbenchModule
{
	override lazy val registry: WorkbenchRegistry = new InternalWorkbenchRegistry
	override lazy val definitions: Definitions = new WorkbenchDefinitions(this.modid, this.log)

	override def createNewWorkbenchRecipe(input: ItemStack, upgrade: ItemStack, modifier: String, output: ItemStack, energycost: Double, time: Int): WorkbenchRecipe =
	{
		new InternalWorkbenchRecipe(input, upgrade, modifier, output, energycost, time)
	}
}
