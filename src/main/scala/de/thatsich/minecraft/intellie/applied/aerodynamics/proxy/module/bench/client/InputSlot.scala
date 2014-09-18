package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.client


import de.thatsich.minecraft.common.proxy.module.container.SlotSide.SlotSide
import de.thatsich.minecraft.common.proxy.module.container.{BaseSlot, SlotState}
import de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench.WorkbenchCraftRecipeStorage
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack


/**
 * only accepts powered armor of AppAero
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class InputSlot(player: EntityPlayer, inventory: IInventory, id: Int, x: Int, y: Int, side: SlotSide, recipestorage: WorkbenchCraftRecipeStorage)
extends BaseSlot(player, inventory, id, x, y, SlotState.Enabled, side)
        with HoloSlot
{
	val holoSlotOffsetX: Int = 0
	val holoSlotOffsetY: Int = 0
	val textureNamespace: String = "appaero"
	val texturePath: String = "textures/gui/tiles.png"

	override def isItemValid(is: ItemStack): Boolean =
	{
		this.recipestorage.internalInputs.foreach(
			storedIS => if (storedIS.isItemEqual(is)) return true
		)

		false
	}
}
