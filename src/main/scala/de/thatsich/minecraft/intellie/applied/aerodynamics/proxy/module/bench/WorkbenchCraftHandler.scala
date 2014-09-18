package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench


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
class WorkbenchCraftHandler extends ICraftHandler
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
		if (this.armorTool == null) throw new RegistrationError(this.armorTool.toString + ": Armor or Tool is not a valid item.")
		if (this.upgrade == null) throw new RegistrationError(this.upgrade.toString + ": Upgrade is not a valid item.")
		if (this.attribute == null) throw new RegistrationError(this.attribute.toString + ": Attribute is not a valid item.")

		val armorToolStack: ItemStack = this.armorTool.getItemStack
		val upgradeStack: ItemStack = this.upgrade.getItemStack
		val attributeStack: ItemStack = this.attribute.getItemStack

		if (armorToolStack == null) throw new RegistrationError(this.armorTool.toString + ": Armor or Tool is not a valid item.")
		if (upgradeStack == null) throw new RegistrationError(this.upgrade.toString + ": Upgrade is not a valid item.")
		if (attributeStack == null) throw new RegistrationError(this.attribute.toString + ": Attribute is not a valid item.")

		val craftRecipe: WorkbenchCraftRecipe = new WorkbenchCraftRecipe(armorToolStack, upgradeStack, attributeStack)

		val storage: WorkbenchCraftRecipeStorage = WorkbenchCraftRecipeStorage

		storage.internalInputs.add(armorToolStack)
		storage.internalUpgrades.add(upgradeStack)
		storage.internalAttributes.add(attributeStack)
		storage.internalCraftRecipes.add(craftRecipe)
	}
}
