package de.thatsich.minecraft.common.proxy.module.registry


import de.thatsich.minecraft.common.proxy.module.item.NBTKeys
import de.thatsich.minecraft.common.util.nbt.NBTTags

import scala.collection.{Set, mutable}


/**
 * 
 *
 * @author thatsIch
 * @since 15.09.2014.
 */
class NBTKeyRegistry
{
	private val properties: mutable.Set[String] = mutable.Set[String]()

	def getNBTKeys: Set[String] = this.properties.toSet

	def addNBTKeys(keys: NBTKeys): Unit = keys.getNBTKeys.foreach(key => this.addNBTTags(key))

	private def addNBTTags(tags: NBTTags): Unit = tags.values.foreach(nbt => this.properties += nbt.toString)
}
