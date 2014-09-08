package de.thatsich.minecraft.common.module.item


import scala.collection._


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

	abstract class BaseNBTProperty extends Enumeration
	{
		properties += this.toString().toLowerCase

		implicit def valuesToString(value: Value): String = value.toString.toLowerCase
	}

}