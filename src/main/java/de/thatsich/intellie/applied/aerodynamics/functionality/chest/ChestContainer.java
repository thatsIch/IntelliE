package de.thatsich.intellie.applied.aerodynamics.functionality.chest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 @author thatsIch
 @since 03.04.2014. */
public class ChestContainer extends Container
{
	private EntityPlayer player;
	private IInventory chest;

	public ChestContainer( IInventory playerInventory, IInventory chestInventory, int xSize, int ySize )
	{
		chest = chestInventory;
		player = ( (InventoryPlayer) playerInventory ).player;
		chestInventory.openInventory();
		layoutContainer( playerInventory, chestInventory, xSize, ySize );
	}

	protected void layoutContainer( IInventory playerInventory, IInventory chestInventory, int xSize, int ySize )
	{
		for( int chestRow = 0; chestRow < 6; chestRow++ )
		{
			for( int chestCol = 0; chestCol < 9; chestCol++ )
			{
				final int index = chestCol + chestRow * 9;
				final int x = 12 + chestCol * 18;
				final int y = 8 + chestRow * 18;
				final ValidatingSlot slot = new ValidatingSlot( chestInventory, index, x, y );
			}
		}

		int leftCol = ( xSize - 162 ) / 2 + 1;
		for( int playerInvRow = 0; playerInvRow < 3; playerInvRow++ )
		{
			for( int playerInvCol = 0; playerInvCol < 9; playerInvCol++ )
			{
				addSlotToContainer( new Slot( playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, ySize - ( 4 - playerInvRow ) * 18
						- 10 ) );
			}
		}

		for( int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++ )
		{
			addSlotToContainer( new Slot( playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, ySize - 24 ) );
		}
	}

	@Override
	public ItemStack transferStackInSlot( EntityPlayer p, int i )
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get( i );
		if( slot != null && slot.getHasStack() )
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if( i < 54 )
			{
				if( !mergeItemStack( itemstack1, 54, inventorySlots.size(), true ) )
				{
					return null;
				}
			}
			else if( !( itemstack == null ) )
			{
				return null;
			}
			else if( !mergeItemStack( itemstack1, 0, 54, false ) )
			{
				return null;
			}
			if( itemstack1.stackSize == 0 )
			{
				slot.putStack( null );
			}
			else
			{
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}

	@Override
	public void onContainerClosed( EntityPlayer entityplayer )
	{
		super.onContainerClosed( entityplayer );
		chest.closeInventory();
	}

	@Override
	public boolean canInteractWith( EntityPlayer player )
	{
		return chest.isUseableByPlayer( player );
	}

	public EntityPlayer getPlayer()
	{
		return player;
	}
}
