package de.thatsich.minecraft.common.module

import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import de.thatsich.minecraft.common.util.string.ID
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
abstract class BaseItem(modid: ID, itemName: ID, log: Log) extends Item
	with NBTKeyStorage
{
	private final val name: String = this.itemName
	private final val id: String = this.modid

	this.setTextureName(s"$id:$name")

	override def getUnlocalizedName(is: ItemStack): String = this.getUnlocalizedName

	override def getUnlocalizedName: String = s"$id.item.$name"
}
