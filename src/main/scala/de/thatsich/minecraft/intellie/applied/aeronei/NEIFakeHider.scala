package de.thatsich.minecraft.intellie.applied.aeronei


import codechicken.nei.api.API
import de.thatsich.minecraft.common.log.Log
import net.minecraft.item.{Item, ItemStack}


/**
 *
 *
 * @author thatsIch
 * @since 30.08.2014.
 */
class NEIFakeHider(items: Seq[Item], log: Log)
{
	def hideItemsInNEI(): Unit =
	{
		this.items.foreach(is =>
		{
			API.hideItem(new ItemStack(is))
			this.log.debug(s"Hid $is from NEI.")
		})
		this.log.info(s"Hid ${this.items.size} elements from NEI.")
	}
}
