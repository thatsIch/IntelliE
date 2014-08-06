package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.bench

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity

/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchTileEntity extends TileEntity with IInventory
{
	private val items: Array[ ItemStack ] = new Array[ ItemStack ]( 6 )


	override def canUpdate: Boolean = false

	def getSizeInventory: Int = this.items.length

	def decrStackSize( index: Int, count: Int ): ItemStack =
	{
		var is: ItemStack = this.getStackInSlot( index )

		if( is != null )
		{
			if( is.stackSize <= count )
			{
				this.setInventorySlotContents( index, null )
			}
			else
			{
				is = is.splitStack( count )
				this.markDirty( )
			}
		}

		is
	}

	def closeInventory( ): Unit =
	{}

	/**
	 * can only put in stacks of max size 1
	 *
	 * @return 1
	 */
	def getInventoryStackLimit: Int = 1

	/**
	 * What is valid
	 * @param i index
	 * @param is item
	 * @return
	 */
	def isItemValidForSlot( i: Int, is: ItemStack ): Boolean =
	{
		// TODO change to other things later on like only my tools and stuff
		is.isItemEqual( new ItemStack( Blocks.anvil ) )
	}

	def getStackInSlotOnClosing( index: Int ): ItemStack =
	{
		val is: ItemStack = this.getStackInSlot( index )
		this.setInventorySlotContents( index, null )

		is
	}

	def openInventory( ): Unit =
	{}

	def setInventorySlotContents( index: Int, is: ItemStack ): Unit =
	{
		this.items( index ) = is

		if( is != null && is.stackSize > this.getInventoryStackLimit )
		{
			is.stackSize = this.getInventoryStackLimit
		}
	}

	/**
	 * Distance of interaction range of player
	 *
	 * @param p interacting player
	 * @return if distance is smaller than 8
	 */
	def isUseableByPlayer( p: EntityPlayer ): Boolean =
	{
		p.getDistanceSq( this.xCoord + 0.5, yCoord + 0.5, zCoord + 0.5 ) <= 64
	}

	/**
	 * accesses the stored inventory array
	 *
	 * @param index index of accessed inventory array
	 *
	 * @return corresponding itemstack in inventory array with index
	 */
	def getStackInSlot( index: Int ): ItemStack = this.items( index )

	def hasCustomInventoryName: Boolean = false

	def getInventoryName: String = "WorkbenchInventory"
}
