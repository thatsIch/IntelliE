package de.thatsich.minecraft.common.module.registry.fake


import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import net.minecraft.item.Item

import scala.collection.Set


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class NBTKeyExtractor
{
	def extractNBTKeys(item: Item): Set[String] =
	{
		item match
		{
			case keystorage: NBTKeyStorage => keystorage.getNBTKeys
			case _                         => Set[String]()
		}
	}
}
