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
class NEIItemStackHider(stacks: Iterable[ItemStack], log: Log)
{
	def hideItemsInNEI(): Unit =
	{
		this.stacks.foreach(stack =>
		{
			API.hideItem(stack)
			this.log.debug(s"Hid ${stack.getItem.getUnlocalizedName} from NEI.")
		})
		this.log.info(s"Hid ${this.stacks.size} elements from NEI.")
	}
}
