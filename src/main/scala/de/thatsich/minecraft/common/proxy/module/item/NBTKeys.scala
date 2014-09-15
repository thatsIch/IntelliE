package de.thatsich.minecraft.common.proxy.module.item


import de.thatsich.minecraft.common.util.nbt.NBTTags


/**
 * 
 *
 * @author thatsIch
 * @since 15.09.2014.
 */
trait NBTKeys
{
	def getNBTKeys: Seq[NBTTags]
}
