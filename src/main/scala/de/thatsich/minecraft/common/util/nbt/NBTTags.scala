package de.thatsich.minecraft.common.util.nbt

/**
 * 
 *
 * @author thatsIch
 * @since 13.09.2014.
 */
trait NBTTags
{
	def values: Seq[BoundNBTProperty[_ <: AnyVal]]
}
