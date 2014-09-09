package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy

import net.minecraft.item.ItemStack


/**
 * 
 *
 * @author thatsIch
 * @since 09.09.2014.
 */
trait NBTKeyRegistry
{
	def addNBTKey(key: String): Unit

	def allKeys: Seq[String]

	def allKeysAsItemStack: Seq[ItemStack]
}
