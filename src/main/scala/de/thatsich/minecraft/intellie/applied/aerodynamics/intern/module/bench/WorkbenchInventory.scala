package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import appeng.api.definitions.{Items, Materials}
import appeng.api.{AEApi, IAppEngApi, definitions}
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.common.item.AAEPoweredItemArmor
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.DissemblerItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{IInventory, ISidedInventory}
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
trait WorkbenchInventory extends TileEntity with IInventory with ISidedInventory
{
	protected val items: Array[ItemStack] = new Array[ItemStack](3)

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
			}

			this.markDirty()
		}

		is
	}

	def closeInventory(): Unit =
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
	def isItemValidForSlot(i: Int, is: ItemStack): Boolean =
	{
		val item: Item = is.getItem
		val api: IAppEngApi = AEApi.instance()
		val apiBlocks: definitions.Blocks = api.blocks()
		val apiItems: Items = api.items()
		val apiMats: Materials = api.materials()

		// first slot only dissembler and armor
		if (i == 0)
		{
			item.isInstanceOf[DissemblerItem] ||
				item.isInstanceOf[AAEPoweredItemArmor]
		}

		// second slot upgrades only
		else if (i == 1)
		{
			apiBlocks.blockEnergyCell.sameAs(is) ||
				apiBlocks.blockEnergyCellDense.sameAs(is) ||
				apiItems.itemCell1k.sameAs(is) ||
				apiItems.itemCell4k.sameAs(is) ||
				apiItems.itemCell16k.sameAs(is) ||
				apiItems.itemCell64k.sameAs(is) ||
				apiMats.materialCardSpeed.sameAs(is) ||
				apiMats.materialCalcProcessor.sameAs(is) ||
				apiMats.materialLogicProcessor.sameAs(is) ||
				apiMats.materialEngProcessor.sameAs(is)
		}

		// third slot nothing since output
		else
		{
			false
		}
	}

	def getStackInSlotOnClosing(index: Int): ItemStack =
	{
		val is: ItemStack = this.getStackInSlot(index)
		this.setInventorySlotContents(index, null)

		is
	}

	def openInventory(): Unit =
	{}

	def setInventorySlotContents(index: Int, is: ItemStack): Unit =
	{
		this.items(index) = is

		if (is != null && is.stackSize > this.getInventoryStackLimit)
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
	def isUseableByPlayer(p: EntityPlayer): Boolean =
	{
		p.getDistanceSq(this.xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64
	}

	/**
	 * accesses the stored inventory array
	 *
	 * @param index index of accessed inventory array
	 *
	 * @return corresponding itemstack in inventory array with index
	 */
	def getStackInSlot(index: Int): ItemStack = this.items(index)

	def hasCustomInventoryName: Boolean = false

	def getInventoryName: String = "WorkbenchInventory"

	private final val access = Array(0, 1, 2)

	def getAccessibleSlotsFromSide(side: Int): Array[Int] = this.access

	def canExtractItem(slot: Int, is: ItemStack, side: Int): Boolean =
	{
		slot == 2
	}

	def canInsertItem(slot : Int, is : ItemStack, side : Int): Boolean = true
}
