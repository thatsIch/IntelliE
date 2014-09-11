package de.thatsich.minecraft.common.module.item


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

	def addNBTs(nbts: BaseNBTProperty): Unit =
	{
		val valueset = nbts.values
		valueset foreach(value => this.properties += value.toString.toLowerCase)
	}

	abstract class BaseNBTProperty extends Enumeration
	{
		implicit def valuesToString(value: Value): String = value.toString.toLowerCase
	}

}