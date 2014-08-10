package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import appeng.api.implementations.items.IAEItemPowerStorage
import cpw.mods.fml.relauncher.{Side, SideOnly}
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.common.item.AAEPoweredItemArmor
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.DissemblerItem
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
class WorkbenchTileEntity extends TileEntity with WorkbenchInventory
{
	private var modificationTime: Int = 0

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

		if (this.canModify)
		{
			this.modificationTime += 1

			if (this.modificationTime == 200)
			{
				this.modificationTime = 0
				this.modifyItem()
				invChanged = true
			}
		}
		else
		{
			this.modificationTime = 0
		}

		if (invChanged)
		{
			this.markDirty()
		}
	}

	def canModify: Boolean =
	{
		this.items(0) != null && this.items(1) != null && this.items(2) == null
		// TODO not maxed out
	}

	def modifyItem(): Unit =
	{
		if (this.canModify)
		{
			val armorTool: ItemStack = this.getStackInSlotOnClosing(0)
			val upgrade: ItemStack = this.getStackInSlotOnClosing(1)

			armorTool.getItem match
			{
				case dissembler: DissemblerItem =>
					upgrade.getItem match
					{
						case powerStorage: IAEItemPowerStorage =>
							val currentUpgrade: Double = powerStorage.getAECurrentPower(upgrade)
							val maxUpgrade: Double = powerStorage.getAEMaxPower(upgrade)

							dissembler.addAEMaxPower(armorTool, maxUpgrade)
							dissembler.injectAEPower(armorTool, currentUpgrade)
							println(s"Increase max capacity by $maxUpgrade and energy level by $currentUpgrade" )

						case any => println(s"Unsupported upgrade $any")
					}

				case armor: AAEPoweredItemArmor =>
					upgrade.getItem match
					{
						case powerStorage: IAEItemPowerStorage =>
							val currentUpgrade: Double = powerStorage.getAECurrentPower(upgrade)
							val maxUpgrade: Double = powerStorage.getAEMaxPower(upgrade)

							armor.addAEMaxPower(armorTool, maxUpgrade)
							armor.injectAEPower(armorTool, currentUpgrade)

						case any => println(s"Unsupported upgrade $any")
					}

				case any => println(s"Unsupported item to upgrade $any")
			}

			this.setInventorySlotContents(2, armorTool.copy())
		}
	}
}
