package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import net.minecraft.item.ItemStack
import net.minecraft.nbt.{NBTTagCompound, NBTTagList}
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchTileEntity extends TileEntity with WorkbenchInventory
{
	override def canUpdate: Boolean = false

	override def writeToNBT(compound: NBTTagCompound): Unit =
	{
		super.writeToNBT(compound)

		val items: NBTTagList = new NBTTagList

		for (invIndex <- 0 to this.getSizeInventory)
		{
			val stack: ItemStack = this.getStackInSlot(invIndex)

			if (stack != null)
			{
				val item: NBTTagCompound = new NBTTagCompound
				item.setByte("Slot", invIndex.asInstanceOf[Byte])
				stack.writeToNBT(compound)
				items.appendTag(item)
			}
		}

		compound.setTag("Items", items)
	}

	override def readFromNBT(compound: NBTTagCompound): Unit =
	{
		super.readFromNBT(compound)

		val items: NBTTagList = compound.getTagList("Items", 0)

		for (index <- 0 to items.tagCount())
		{
			val item: NBTTagCompound = items.getCompoundTagAt(index)
			val slot: Byte = item.getByte("Slot")

			if (slot >= 0 && slot < this.getSizeInventory)
			{
				this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item))
			}
		}
	}
}
