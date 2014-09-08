package de.thatsich.minecraft.common.module.registry.fake


import de.thatsich.minecraft.common.module.item.NBTKeyStorage
import net.minecraft.item.{Item, ItemStack}

import scala.collection.Set


/**
 * 
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
class NBTKeyExtractor
{
	def extractNBTKeys(is: ItemStack): Set[String] =
	{
		val item: Item = is.getItem
		item match
		{
			case keystorage: NBTKeyStorage => keystorage.getNBTKeys
			case _                         => Set[String]()
		}
	}
}
