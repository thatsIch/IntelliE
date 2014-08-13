package de.thatsich.minecraft.common.module.registry

/**
 *
 *
 * @author thatsIch
 * @since 13.08.2014.
 */
trait BlockGuiHasher
{
	protected def getUniqueID(str: String): Int =
	{
		var h: Int = 0

		for (ch <- str)
		{
			h = 31 * h + ch
		}

		h
	}
}
