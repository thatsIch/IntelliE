package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client


import de.thatsich.minecraft.common.module.container.slot.SlotSide.SlotSide
import de.thatsich.minecraft.common.module.container.slot.{BaseSlot, SlotState}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.WorkbenchCraftRecipeStorage
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack


/**
 * only accepts powered armor of AppAero
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class InputSlot(player: EntityPlayer, inventory: IInventory, id: Int, x: Int, y: Int, side: SlotSide) extends BaseSlot(player, inventory, id, x, y, SlotState.Enabled, side)
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
