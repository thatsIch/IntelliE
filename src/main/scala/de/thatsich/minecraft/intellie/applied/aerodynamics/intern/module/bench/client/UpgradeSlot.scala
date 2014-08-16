package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.client


import de.thatsich.minecraft.common.module.container.slot.SlotSide.SlotSide
import de.thatsich.minecraft.common.module.container.slot.{BaseSlot, SlotStateWTF}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench.WorkbenchCraftRecipeStorage
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class UpgradeSlot(player: EntityPlayer, inventory: IInventory, id: Int, x: Int, y: Int, side: SlotSide) extends BaseSlot(player, inventory, id, x, y, SlotStateWTF.Enabled, side)
{
	protected val storage = WorkbenchCraftRecipeStorage

	override def isItemValid(is: ItemStack): Boolean =
	{
		this.storage.internalUpgrades.foreach(
			storedIS => if (storedIS.isItemEqual(is)) return true
		)

		false
	}
}
