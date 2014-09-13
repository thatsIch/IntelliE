package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy


import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.item.SimpleFakeItem
import de.thatsich.minecraft.common.util.string.id.SimpleID
import de.thatsich.minecraft.common.util.string.ModID
import net.minecraft.item.ItemStack

import scala.collection.mutable


/**
 * 
 *
 * @author thatsIch
 * @since 10.09.2014.
 */
class InternalNBTKeyRegistry(modid: ModID, log: Log) extends NBTKeyRegistry
{
	private val registry = new mutable.HashMap[String, ItemStack]()

	override def addNBTKey(key: String): Unit =
	{
		if (!this.registry.contains(key))
		{
			val id = new SimpleID(key)
			val item = new SimpleFakeItem(id, this.modid, this.log)
			val stack = new ItemStack(item)
			val pair = (key, stack)
			this.registry += pair
		}
	}

	override def allKeys: Set[String] =
	{
		this.registry.keySet.toSet
	}

	override def allKeysAsItemStack: Iterable[ItemStack] =
	{
		this.registry.values
	}
}
