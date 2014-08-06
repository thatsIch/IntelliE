package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench

import net.minecraft.entity.player.{EntityPlayer, InventoryPlayer}
import net.minecraft.inventory.{Container, IInventory}
import net.minecraft.tileentity.TileEntity

/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
abstract class BaseContainer( player: InventoryPlayer, tileEntity: TileEntity ) extends Container
{
	var isContainerValid: Boolean    = true
	val locked          : Set[ Int ] = Set( )

	def canInteractWith( player: EntityPlayer ): Boolean =
	{
		if( this.isContainerValid )
		{
			this.tileEntity match
			{
				case inventory: IInventory => inventory.isUseableByPlayer( player )
			}
		}

		this.isContainerValid
	}

	protected def bindPlayerInventory( player: InventoryPlayer, offsetX: Int, offsetY: Int ): Unit =
	{
		//		for ( i <- 0 to 2; j <- 0 to 8) {
		//			val elem: Int = j + i * 9 + 9
		//			if (this.locked.contains(elem)) {
		//				this.addSlotToContainer(new SlotDisabled(player, elem, 8))
		//			}
		//		}
		//		for (int i = 0; i < 3; i++) {
		//		for (int j = 0; j < 9; j++) {
		//			if (this.locked.contains(Integer.valueOf(j + i * 9 + 9))) {
		//				addSlotToContainer(new SlotDisabled(inventoryPlayer, j + i * 9 + 9, 8 + j * 18 + offset_x, offset_y + i * 18));
		//			} else {
		//				addSlotToContainer(new SlotPlayerInv(inventoryPlayer, j + i * 9 + 9, 8 + j * 18 + offset_x, offset_y + i * 18));
		//			}
		//		}
		//	}
		//		for (int i = 0; i < 9; i++) {
		//		if (this.locked.contains(Integer.valueOf(i))) {
		//			addSlotToContainer(new SlotDisabled(inventoryPlayer, i, 8 + i * 18 + offset_x, 58 + offset_y));
		//		} else {
		//			addSlotToContainer(new SlotPlayerHotBar(inventoryPlayer, i, 8 + i * 18 + offset_x, 58 + offset_y));
		//		}
	}

	//	}
}

