package de.thatsich.minecraft.common.module.registry


import scala.collection._
import scala.util.hashing.MurmurHash3


/**
 * A hasher for blocks with guis
 * Uses the Murmur3 implementation of Scala
 *
 * @author thatsIch
 * @since 13.08.2014.
 */
trait BlockGuiHasher
{
	private[this] val map = mutable.Map[String, Int]()

	protected def hash(key: String): Int =
	{
		val maybeInt: Option[Int] = this.map get key

		maybeInt match
		{
			case Some(hash) => hash
			case None       =>
				val hash = MurmurHash3.stringHash(key)
				this.map += key -> hash
				hash
		}
	}
}
