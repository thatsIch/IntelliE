package de.thatsich.minecraft.intellie.applied.aeronei


import java.awt.Rectangle

import codechicken.nei.PositionedStack
import codechicken.nei.recipe.TemplateRecipeHandler
import com.google.common.collect.Lists
import de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.client.WorkbenchGui
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.{WorkbenchCraftRecipe, WorkbenchCraftRecipeStorage}
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.util.{ResourceLocation, StatCollector}


/**
 * NEI recipe handler
 * handles display, rendering and registration of the recipes
 *
 * @author thatsIch
 * @since 20.08.2014.
 */
// TODO use the API registry and replace the WorkbenchCraftRecipeStorage because of mutable state
class NEIWorkbenchRecipeHandler extends TemplateRecipeHandler
{
	/**
	 * string of gui textures used as background
	 *
	 * @return gui texture of workbench
	 */
	def getGuiTexture: String =
	{
		val resloc = new ResourceLocation(AppliedAerodynamics.id, "textures/gui/workbench.png")

		resloc.toString
	}

	/**
	 * Display name in NEI above the recpes
	 *
	 * @return localized string of workbench
	 */
	def getRecipeName: String = StatCollector.translateToLocal("appaero.gui.workbench.name")

	/**
	 * Hitbox in workbench gui to show all recipes
	 */
	override def loadTransferRects(): Unit =
	{
		this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(73, 29, 27, 16), "workbench"))
	}

	/**
	 * class of the workbench gui container
	 *
	 * @return workbench gui container
	 */
	override def getGuiClass: Class[_ <: GuiContainer] = classOf[WorkbenchGui]

	/**
	 * add the recipes to the list
	 *
	 * @param outputId id of the workbench
	 * @param results something
	 */
	override def loadCraftingRecipes(outputId: String, results: AnyRef*): Unit =
	{
		if (outputId == "workbench" && this.getClass == classOf[NEIWorkbenchRecipeHandler])
		{
			WorkbenchCraftRecipeStorage.internalCraftRecipes.foreach
			{
				recipe => this.arecipes.add(new CachedWorkbenchRecipe(recipe))
			}
		}
	}

	/**
	 * Draws additional information
	 *
	 * @param recipe position of the recipe you are looking at
	 */
	override def drawExtras(recipe: Int): Unit =
	{
		val cached = this.arecipes.get(recipe).asInstanceOf[CachedWorkbenchRecipe]
		val modifier = cached.modifier
		val itemmodifier = modifier.item
		val displayString = itemmodifier.stackSize + " " + itemmodifier.getDisplayName

		this.drawCenteredString(displayString, modifier.relx, modifier.rely, 4210752)
	}

	/**
	 * Draws a centered string at position (x,y) with a color
	 *
	 * @param string to be drawn string
	 * @param x center of string
	 * @param y y pos
	 * @param color color of string
	 */
	private def drawCenteredString(string: String, x: Int, y: Int, color: Int): Unit =
	{
		val fr = Minecraft.getMinecraft.fontRenderer
		val width = fr.getStringWidth(string)
		fr.drawString(string, x - width / 2, y, color)
	}

	/**
	 * wrapper class which handles the positions of the several itemstacks in the recipe
	 *
	 * @param recipe recipe in workbench
	 */
	private class CachedWorkbenchRecipe(recipe: WorkbenchCraftRecipe) extends CachedRecipe
	{
		val modifier = new PositionedStack(recipe.attribute, 88, 15)
		private val input = new PositionedStack(recipe.input, 34, 29)
		private val upgrade = new PositionedStack(recipe.upgrade, 54, 29)
		private val result = new PositionedStack(recipe.input, 105, 29)

		/**
		 * Ingredients of recipe:
		 * - armor/tool
		 * - upgrade
		 *
		 * @return list of ingredients
		 */
		override def getIngredients: java.util.List[PositionedStack] = Lists.newArrayList(this.input, this.upgrade)

		/**
		 * result of the recipe
		 *
		 * @return result
		 */
		def getResult: PositionedStack = this.result
	}

}
