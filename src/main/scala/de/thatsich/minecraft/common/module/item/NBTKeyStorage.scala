package de.thatsich.minecraft.common.module.item


import de.thatsich.minecraft.common.util.nbt.{NBTTags, BoundNBTProperty}

import scala.collection._
import scala.language.implicitConversions


/**
 * 
 *
 * @author thatsIch
 * @since 04.09.2014.
 */
trait NBTKeyStorage
{
	private val properties: mutable.Set[String] = mutable.Set[String]()

	def getNBTKeys: Set[String] = this.properties.toSet

	def addNBT(nbt: BoundNBTProperty): Unit = this.properties += nbt

	def addNBTs(nbts: NBTTags): Unit = nbts.values.foreach(this.properties += _)
}