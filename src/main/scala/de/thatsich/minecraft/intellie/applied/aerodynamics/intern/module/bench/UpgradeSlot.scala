package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.bench


import appeng.api.definitions.{Blocks, Items, Materials}
import appeng.api.util.AEItemDefinition
import appeng.api.{AEApi, IAppEngApi}
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 09.08.2014.
 */
class UpgradeSlot(inventory: IInventory, id: Int, x: Int, y: Int) extends Slot(inventory, id, x, y)
{
	override def isItemValid(stack: ItemStack): Boolean =
	{
		val api: IAppEngApi = AEApi.instance()
		val blocks: Blocks = api.blocks()
		val items: Items = api.items()
		val mats: Materials = api.materials()

		// increase energy capacity of tool/armor
		val energyCell: AEItemDefinition = blocks.blockEnergyCell
		val denseEnergyCell: AEItemDefinition = blocks.blockEnergyCellDense

		// increase mining speed/flyspeed
		val accel: AEItemDefinition = mats.materialCardSpeed

		val eng: AEItemDefinition = mats.materialEngProcessor
		val calc: AEItemDefinition = mats.materialCalcProcessor
		val logic: AEItemDefinition = mats.materialLogicProcessor

		// set mining level/armor level
		val cell1k: AEItemDefinition = items.itemCell1k
		val cell4k: AEItemDefinition = items.itemCell4k
		val cell16k: AEItemDefinition = items.itemCell16k
		val cell64k: AEItemDefinition = items.itemCell64k

		energyCell.sameAs(stack) ||
			denseEnergyCell.sameAs(stack) ||
			accel.sameAs(stack) ||
			cell1k.sameAs(stack) ||
			cell4k.sameAs(stack) ||
			cell16k.sameAs(stack) ||
			cell64k.sameAs(stack) ||
			eng.sameAs(stack) ||
			calc.sameAs(stack) ||
			logic.sameAs(stack)
	}
}
