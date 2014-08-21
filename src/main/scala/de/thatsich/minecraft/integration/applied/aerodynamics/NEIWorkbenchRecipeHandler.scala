package de.thatsich.minecraft.integration.applied.aerodynamics


import java.awt.Rectangle

import codechicken.nei.PositionedStack
import codechicken.nei.recipe.TemplateRecipeHandler
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.WorkbenchCraftRecipe
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client.WorkbechGui
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.util.{ResourceLocation, StatCollector}


/**
 *
 *
 * @author thatsIch
 * @since 20.08.2014.
 */
class NEIWorkbenchRecipeHandler extends TemplateRecipeHandler
{
	def getGuiTexture: String =
	{
		val resloc = new ResourceLocation(AppliedAerodynamics.id, "textures/gui/workbench.png")

		resloc.toString
	}

	def getRecipeName: String = StatCollector.translateToLocal("appaero.gui.workbench.name")

	override def loadTransferRects(): Unit =
	{
		this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(84, 23, 24, 18), "workbench"))
	}

	override def getGuiClass: Class[_ <: GuiContainer] = classOf[WorkbechGui]

	override def loadCraftingRecipes(outputId: String, results: AnyRef*): Unit =
	{
		outputId match
		{
			case "workbench" => if (this.getClass == classOf[NEIWorkbenchRecipeHandler])
			{
				this.arecipes
			}

			case _ => super.loadCraftingRecipes(outputId, results)
		}
	}

	private class CachedWorkbenchRecipe(recipe: WorkbenchCraftRecipe) extends CachedRecipe
	{
		def getResult: PositionedStack = ???
	}
}
