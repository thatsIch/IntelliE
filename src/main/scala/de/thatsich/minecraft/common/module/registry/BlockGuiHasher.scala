package de.thatsich.minecraft.common.module.registry


import scala.util.hashing.MurmurHash3
/**
 * A hasher for blocks with guis
 * Uses the SuperFastHash of
 * http://www.azillionmonkeys.com/qed/hash.html
 *
 * @author thatsIch
 * @since 13.08.2014.
 */
trait BlockGuiHasher
{
	private[this] val map = Map[String, Int]()

	protected def hash(key: String): Int =
	{
		MurmurHash3.stringHash(key)
	}

	private def calcHash(key: String): Int =
	{
		var length = key.length
		var hash = length
		var tmp = 0

		val rem = length & 3
		length >>= 2

		var i = 0
		while (i < length)
		{
			hash += this.get16bits(key, i)
			tmp = (this.get16bits(key, i + 2) << 11) ^ hash
			hash = (hash << 16) ^ tmp
			hash += hash >> 11
			i += 4
		}

		rem match
		{
			case 3 =>
				hash += this.get16bits(key, i)
				hash ^= hash << 16
				hash ^= key.charAt(i + 1)
				hash += hash >> 11
			case 2 =>
				hash += get16bits(key, i)
				hash ^= hash << 11
				hash += hash >> 17
			case 1 =>
				hash += key.charAt(i)
				hash ^= hash << 10
				hash += hash >> 1
		}

		hash ^= hash << 3
		hash += hash >> 5
		hash ^= hash << 4
		hash += hash >> 17
		hash ^= hash << 25
		hash += hash >> 6

		hash
	}

	private def get16bits(key: String, index: Int): Int =
	{
		key.charAt(index) | (key.charAt(index + 1) << 8)
	}
}
