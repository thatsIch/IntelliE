package de.thatsich.minecraft.common.module.registry.fake


import net.minecraft.item.Item

import scala.collection.{Seq, Set, mutable}


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class NBTKeyCollector(items: Seq[Item])
{
	private val extractor = new NBTKeyExtractor
	private val collection: mutable.Set[String] = mutable.Set[String]()
	this.items.foreach(this.collection ++= this.extractor.extractNBTKeys(_))

	def getNBTKeys: Set[String] = this.collection.toSet
}