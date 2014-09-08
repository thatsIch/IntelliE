package de.thatsich.minecraft.intellie.applied.aeronei

import codechicken.nei.api.API
import de.thatsich.minecraft.common.log.Log
import net.minecraft.item.ItemStack


/**
 *
 *
 * @author thatsIch
 * @since 30.08.2014.
 */
class NEIFakeHider(itemstacks: Seq[ItemStack], log: Log)
{
	def hideItemsInNEI(): Unit =
	{
		this.itemstacks.foreach(is =>
		{
			API.hideItem(is)
			this.log.debug(s"Hid $is from NEI.")
		})
		this.log.info(s"Hid ${this.itemstacks.size} elements from NEI.")
	}
}
