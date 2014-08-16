package de.thatsich.minecraft.common.module.item


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.string.id.ID
import net.minecraft.item.{ItemStack, Item}


/**
 *
 *
 * @author thatsIch
 * @since 10.08.2014.
 */
abstract class BaseItem(modid: ID, itemName: ID, log: Log) extends Item
{
	private final val name: String = this.itemName
	private final val id: String = this.modid

	this.setUnlocalizedName(this.name)
	this.setTextureName(s"$id:$name")

	override def getUnlocalizedName: String = s"$id.item.$name"

	override def getUnlocalizedName(is : ItemStack): String = this.getUnlocalizedName

	/**
	 * integrates the mod id into the item
	 *
	 * @param name name of the item
	 *
	 * @return itself
	 */
	override def setUnlocalizedName(name: String): Item = super.setUnlocalizedName(s"$id.$name")
}
