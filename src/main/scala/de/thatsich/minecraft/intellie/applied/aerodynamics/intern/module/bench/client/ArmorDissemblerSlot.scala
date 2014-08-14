package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client


import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.WorkbenchCraftRecipeStorage
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack


/**
 * only accepts powered armor of AppAero
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class ArmorDissemblerSlot(inventory: IInventory, id: Int, x: Int, y: Int) extends Slot(inventory, id, x, y)
{
	private val storage = WorkbenchCraftRecipeStorage

	override def isItemValid(is: ItemStack): Boolean =
	{
		this.storage.internalInputs.foreach(
			storedIS => if (storedIS.isItemEqual(is)) return true
		)

		false
	}
}
