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
		val uprade: ItemStack = this.getStackInSlotOnClosing(1)
		val attribute: ItemStack = task.attribute
		val output: ItemStack = input.copy()

		val attributeName: String = this.extractItemName(attribute)
		val attributeValue: Int = attribute.stackSize

		val outputTag: NBTTagCompound = this.getNBTData(output)
		val attributeValueFromTag: Int = outputTag.getInteger(attributeName)
		outputTag.setInteger(attributeName, attributeValueFromTag + attributeValue)
	}

	private def extractItemName(stack: ItemStack): String =
	{
		val unparsedName: String = stack.getUnlocalizedName
		val lastPosition: Int = unparsedName.lastIndexOf('.')
		val parsedName: String = unparsedName.substring(lastPosition)

		parsedName
	}

	// TODO add regression chance based
	//	def modifyItem(): Unit =
	//	{
	//		val armorTool: ItemStack = this.getStackInSlotOnClosing(0)
	//		val upgrade: ItemStack = this.getStackInSlotOnClosing(1)
	//
	//		val armorToolItem = armorTool.getItem
	//
	//		val api = AEApi.instance()
	//		val mats: Materials = api.materials()
	//
	//		armorToolItem match
	//		{
	//			case dissembler: DissemblerItem =>
	//				upgrade.getItem match
	//				{
	//					// add energy
	//					case powerStorage: IAEItemPowerStorage =>
	//						val currentUpgrade: Double = powerStorage.getAECurrentPower(upgrade)
	//						val maxUpgrade: Double = powerStorage.getAEMaxPower(upgrade)
	//
	//						dissembler.addAEMaxPower(armorTool, maxUpgrade)
	//						dissembler.injectAEPower(armorTool, currentUpgrade)
	//
	//					// mining speed
	//					case cell: IStorageCell =>
	//						val current = dissembler.getCurrentMiningSpeed(armorTool)
	//						val additionalLevels = cell.getBytes(upgrade) / 1024
	//
	//						dissembler.setCurrentMiningSpeed(armorTool, current + additionalLevels)
	//
	//					case any =>
	//						// mining level
	//						if (mats.materialLogicProcessor.sameAsStack(upgrade))
	//						{
	//							val current = dissembler.getCurrentMiningLevel(armorTool)
	//							dissembler.setCurrentMiningLevel(armorTool, current + 1)
	//						}
	//
	//						// damage
	//						else if (mats.materialEngProcessor.sameAsStack(upgrade))
	//						{
	//							val current = dissembler.getCurrentDamageVsEntities(armorTool)
	//							dissembler.setCurrentDamageVsEntities(armorTool, current + 1)
	//						}
	//
	//						// charge multiplier
	//						else if (mats.materialCardSpeed.sameAsStack(upgrade))
	//						{
	//							val current = dissembler.getCurrentChargeMultiplier(armorTool)
	//							dissembler.setCurrentChargePerTick(armorTool, current + 1)
	//						}
	//
	//						// energy cost
	//						else if (mats.materialCalcProcessor.sameAsStack(upgrade))
	//						{
	//							val current = dissembler.getCurrentEnergyUsage(armorTool)
	//							dissembler.setCurrentEnergyPerBlockBreak(armorTool, current - 1)
	//						}
	//						else
	//						{
	//							println(s"Unsupported upgrade $any")
	//						}
	//				}
	//
	//			case armor: AAEPoweredItemArmor =>
	//				upgrade.getItem match
	//				{
	//					case powerStorage: IAEItemPowerStorage =>
	//						val currentUpgrade: Double = powerStorage.getAECurrentPower(upgrade)
	//						val maxUpgrade: Double = powerStorage.getAEMaxPower(upgrade)
	//
	//						armor.addAEMaxPower(armorTool, maxUpgrade)
	//						armor.injectAEPower(armorTool, currentUpgrade)
	//
	//					case any => println(s"Unsupported upgrade $any") // TODO remove or better
	//				}
	//
	//			case any => println(s"Unsupported item to upgrade $any") // TODO remove or better
	//		}
	//
	//		this.setInventorySlotContents(2, armorTool.copy())
	//	}

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
