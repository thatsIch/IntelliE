package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.bench


import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.ISidedInventory
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
trait WorkbenchInventory extends TileEntity with ISidedInventory
{
	private final val access = Array(0, 1, 2)
	protected val items: Array[ItemStack] = new Array[ItemStack](3)
	protected val storage = WorkbenchCraftRecipeStorage

	def getSizeInventory: Int = this.items.length

	def decrStackSize(index: Int, count: Int): ItemStack =
	{
		var is: ItemStack = this.getStackInSlot(index)

		if (is != null)
		{
			if (is.stackSize <= count)
			{
				this.setInventorySlotContents(index, null)
			}
			else
			{
				is = is.splitStack(count)
				if (this.getStackInSlot(index).stackSize == 0)
				{
					this.items(index) = null
					this.markDirty()
				}
			}
		}

		is
	}

	def closeInventory(): Unit =
	{}

	def getStackInSlotOnClosing(index: Int): ItemStack =
	{
		val is: ItemStack = this.getStackInSlot(index)
		this.setInventorySlotContents(index, null)

		is
	}

	def setInventorySlotContents(index: Int, is: ItemStack): Unit =
	{
		this.items(index) = is

		if (is != null && is.stackSize > this.getInventoryStackLimit)
		{
			is.stackSize = this.getInventoryStackLimit
		}

		this.markDirty()
	}

	/**
	 * can only put in stacks of max size 1
	 *
	 * @return 1
	 */
	def getInventoryStackLimit: Int = 1

	/**
	 * accesses the stored inventory array
	 *
	 * @param index index of accessed inventory array
	 *
	 * @return corresponding itemstack in inventory array with index
	 */
	def getStackInSlot(index: Int): ItemStack = this.items(index)

	def openInventory(): Unit =
	{}

	/**
	 * Distance of interaction range of player
	 *
	 * @param p interacting player
	 * @return if distance is smaller than 8
	 */
	def isUseableByPlayer(p: EntityPlayer): Boolean =
	{
		p.getDistanceSq(this.xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64
	}

	def hasCustomInventoryName: Boolean = false

	def getInventoryName: String = "WorkbenchInventory"

	def getAccessibleSlotsFromSide(side: Int): Array[Int] = this.access

	def canExtractItem(slot: Int, is: ItemStack, side: Int): Boolean = slot == 2

	def canInsertItem(slot: Int, is: ItemStack, side: Int): Boolean = this.isItemValidForSlot(slot, is)

	/**
	 * What is valid
	 * @param slot index
	 * @param is item
	 * @return
	 */
	def isItemValidForSlot(slot: Int, is: ItemStack): Boolean =
	{
		// first slot only dissembler and armor
		if (slot == 0)
		{
			this.storage.internalInputs.foreach(
				storedIS => if (storedIS.isItemEqual(is)) return true
			)
		}

		// second slot upgrades only
		else if (slot == 1)
		{
			this.storage.internalUpgrades.foreach(
				storedIS => if (storedIS.isItemEqual(is)) return true
			)
		}
		// third slot nothing since output

		false
	}
}
