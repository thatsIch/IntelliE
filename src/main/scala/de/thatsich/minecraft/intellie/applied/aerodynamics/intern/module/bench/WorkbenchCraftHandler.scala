package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import java.util

import appeng.api.exceptions.{RecipeError, RegistrationError}
import appeng.api.recipes.{ICraftHandler, IIngredient}
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 11.08.2014.
 */
class WorkbenchCraftHandler(storage: WorkbenchCraftRecipeStorage) extends ICraftHandler
{
	private var armorTool: IIngredient = null
	private var upgrade: IIngredient = null
	private var attribute: IIngredient = null

	def setup(input: util.List[util.List[IIngredient]], output: util.List[util.List[IIngredient]]): Unit =
	{
		if (input.size() != 1) new RecipeError("Workbench input must be in a single row.")
		if (output.size() != 0) new RecipeError("Workbench does not have an output.")

		val inputRow: util.List[IIngredient] = input.get(0)
		val outputRow: util.List[IIngredient] = output.get(0)

		if (inputRow.size() != 3) new RecipeError("Workbench input must be 3 ingredients.")
		if (outputRow.size() != 0) new RecipeError("Workbench does not have an output.")

		this.armorTool = inputRow.get(0)
		this.upgrade = inputRow.get(1)
		this.attribute = inputRow.get(2)
	}

	def register(): Unit =
	{
		val armorToolStack: ItemStack = this.armorTool.getItemStack
		val upgradeStack: ItemStack = this.upgrade.getItemStack
		val attributeStack: ItemStack = this.attribute.getItemStack

		if (armorToolStack == null || armorToolStack.getItem == null)
		{
			throw new RegistrationError(this.armorTool.toString + ": Armor or Tool is not a valid item.")
		}
		if (upgradeStack == null || upgradeStack.getItem == null)
		{
			throw new RegistrationError(this.upgrade.toString + ": Upgrade is not a valid item.")
		}
		if (attributeStack == null || attributeStack.getItem == null)
		{
			throw new RegistrationError(this.attribute.toString + ": Attribute is not a valid item.")
		}

		val craftRecipe: WorkbenchCraftRecipe = new WorkbenchCraftRecipe(armorToolStack, upgradeStack, "", 1, attributeStack)

		this.storage.addCraftRecipe(craftRecipe)
	}
}
