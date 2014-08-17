package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.BaseItem
import de.thatsich.minecraft.common.string.id.ID
import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.suite.item.ArmorType.ArmorType
import net.minecraft.block.BlockDispenser
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLiving}
import net.minecraft.item.ItemStack
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 16.08.2014.
 */
abstract class BaseItemArmor(armorType: ArmorType, modid: ID, itemName: ID, log: Log) extends BaseItem(modid, itemName, log)
{
	BlockDispenser.dispenseBehaviorRegistry.putObject(this, new AeroDispenseBehavior())

	override def onItemRightClick(is: ItemStack, world: World, player: EntityPlayer): ItemStack =
	{
		val pos: Int = 3 - armorType.id
		val armor: ItemStack = player.getCurrentArmor(pos)

		if (armor == null)
		{
			player.setCurrentItemOrArmor(pos, is.copy())
			is.stackSize = 0
		}

		is
	}

	override def isValidArmor(is: ItemStack, armorType: Int, entity: Entity): Boolean =
	{
		this.armorType.id == armorType
	}

	override def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean = false
}
