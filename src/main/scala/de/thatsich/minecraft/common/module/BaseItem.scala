package de.thatsich.minecraft.common.module


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.util.string.{ID, ModID}
import net.minecraft.item.{ItemStack, Item}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
abstract class BaseItem(itemName: ID, modid: ModID, log: Log) extends Item
{
	private final val name: String = this.itemName
	private final val id: String = this.modid

	this.setTextureName(s"$id:$name")

	override def getUnlocalizedName(is: ItemStack): String = this.getUnlocalizedName

	override def getUnlocalizedName: String = s"$id.item.$name"
}
