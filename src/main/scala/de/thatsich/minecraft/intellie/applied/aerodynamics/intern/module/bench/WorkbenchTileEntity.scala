package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.module.util.NBTAccess
import net.minecraft.item.ItemStack
import net.minecraft.nbt.{NBTTagCompound, NBTTagList}
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.Constants


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchTileEntity extends TileEntity
                                  with WorkbenchInventory
                                  with NBTAccess
{
	var modificationTime: Int = 0

	@SideOnly(Side.CLIENT)
	def isModifying: Boolean =
	{
		this.modificationTime > 0
	}

	@SideOnly(Side.CLIENT)
	def getModificationProgressScaled(scale: Int): Int =
	{
		this.modificationTime * scale / 200
	}

	override def writeToNBT(compound: NBTTagCompound): Unit =
	{
		super.writeToNBT(compound)

		val items: NBTTagList = new NBTTagList

		for (invIndex <- 0 until this.getSizeInventory)
		{
			val stack: ItemStack = this.getStackInSlot(invIndex)

			if (stack != null)
			{
				val item: NBTTagCompound = new NBTTagCompound
				item.setByte("Slot", invIndex.asInstanceOf[Byte])
				stack.writeToNBT(item)
				items.appendTag(item)
			}
		}

		compound.setTag("Items", items)
		compound.setShort("ModTime", this.modificationTime.shortValue())
	}

	override def readFromNBT(compound: NBTTagCompound): Unit =
	{
		super.readFromNBT(compound)

		val items: NBTTagList = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND)
		this.modificationTime = compound.getShort("ModTime")

		for (index <- 0 until items.tagCount())
		{
			val item: NBTTagCompound = items.getCompoundTagAt(index)
			val slot: Int = item.getByte("Slot").asInstanceOf[Int]

			if (slot >= 0 && slot < this.getSizeInventory)
			{
				this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item))
			}
		}
	}

	override def updateEntity(): Unit =
	{
		var invChanged: Boolean = false

		if (!this.worldObj.isRemote)
		{
			val task: WorkbenchCraftRecipe = this.getTask
			if (task != null)
			{
				this.modificationTime += 1

				if (this.modificationTime == 200)
				{
					this.modificationTime = 0
					this.executeTask(task)
					invChanged = true
				}
			}
			else
			{
				this.modificationTime = 0
			}
		}

		if (invChanged)
		{
			this.markDirty()
		}
	}

	private def executeTask(task: WorkbenchCraftRecipe): Unit =
	{
		val input: ItemStack = this.getStackInSlotOnClosing(0)
		this.setInventorySlotContents(1, null)
		val attribute: ItemStack = task.attribute
		val output: ItemStack = input.copy()

		val attributeName: String = this.extractItemName(attribute)
		val attributeValue: Double = attribute.stackSize
		val attributeModifier: Double = if (attribute.getItemDamage != 0) -1 else 1

		val outputTag: NBTTagCompound = this.getNBTData(output)
		val attributeValueFromTag: Double = outputTag.getDouble(attributeName)
		val modifiedAttributeValue: Double = attributeValueFromTag + attributeModifier * attributeValue

		outputTag.setDouble(attributeName, modifiedAttributeValue)

		this.setInventorySlotContents(2, output)
	}

	private def extractItemName(stack: ItemStack): String =
	{
		val unparsedName: String = stack.getUnlocalizedName
		val lastPosition: Int = unparsedName.lastIndexOf('.')
		val parsedName: String = unparsedName.substring(lastPosition + 1)

		parsedName
	}

	private def getTask: WorkbenchCraftRecipe =
	{
		val inputStack: ItemStack = this.getStackInSlot(0)
		val upgradeStack: ItemStack = this.getStackInSlot(1)

		if (inputStack == null || inputStack.stackSize > 1) return null
		if (upgradeStack == null || upgradeStack.stackSize > 1) return null

		for (recipe <- this.storage.internalCraftRecipes)
		{
			if (recipe.input != null && recipe.upgrade != null && recipe.attribute != null)
			{
				if (inputStack.isItemEqual(recipe.input) && upgradeStack.isItemEqual(recipe.upgrade))
				{
					return recipe
				}
			}
		}

		null
	}
}
