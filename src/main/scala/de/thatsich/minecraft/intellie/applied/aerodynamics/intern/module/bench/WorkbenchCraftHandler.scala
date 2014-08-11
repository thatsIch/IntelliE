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
	private var upgradedArmorTool: IIngredient = null

	def setup(input: util.List[util.List[IIngredient]], output: util.List[util.List[IIngredient]]): Unit =
	{
		if (input.size() == 1)
		{
			val firstRow: util.List[IIngredient] = input.get(0)
			if (firstRow.size() == 2)
			{
				this.armorTool = firstRow.get(0)
				this.upgrade = firstRow.get(1)
			}
			else
			{
				new RecipeError("Workbench input must be 2 ingredients in a single row.")
			}
		}
		else
		{
			new RecipeError("Workbench input ingredients cannot be split across 2 rows.")
		}

		if (output.size() == 1)
		{
			val firstRow: util.List[IIngredient] = output.get(0)
			if (firstRow.size() == 1)
			{
			}
			else
			{
				new RecipeError("Workbench must have a single output.")
			}
		}
		else
		{
			new RecipeError("Workbench must have a single output.")
		}
	}

	def register(): Unit =
	{
		val armorToolStack: ItemStack = this.armorTool.getItemStack
		val upgradeStack: ItemStack = this.upgrade.getItemStack
		val upgradedStack: ItemStack = this.upgradedArmorTool.getItemStack

		if (armorToolStack == null || armorToolStack.getItem == null)
		{
			throw new RegistrationError(this.armorTool.toString + ": Armor or Tool is not a valid item.")
		}
		if (upgradeStack == null || upgradeStack.getItem == null)
		{
			throw new RegistrationError(this.upgrade.toString + ": Upgrade is not a valid item.")
		}
		if (upgradedStack == null || upgradedStack.getItem == null)
		{
			throw new RegistrationError(this.upgradedArmorTool.toString + ": Upgraded Armor or Tool is not a valid item.")
		}

		val craftRecipe: WorkbenchCraftRecipe = new WorkbenchCraftRecipe(armorToolStack, upgradeStack, "", 1, upgradedStack)

		this.storage.addCraftRecipe(craftRecipe)
	}
}
