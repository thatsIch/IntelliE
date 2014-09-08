package de.thatsich.minecraft.common.module.registry.fake


import net.minecraft.item.ItemStack

import scala.collection.{Seq, Set, mutable}


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class NBTKeyCollector(items: Seq[ItemStack])
{
	private val extractor = new NBTKeyExtractor
	private val collection: mutable.Set[String] = mutable.Set[String]()
	this.items.foreach(item =>
	{
		this.collection ++= this.extractor.extractNBTKeys(item)
	})

	def getNBTKeys: Set[String] = this.collection.toSet
}