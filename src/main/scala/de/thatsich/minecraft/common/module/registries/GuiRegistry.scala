package de.thatsich.minecraft.common.module.registries


import java.util

import cpw.mods.fml.common.network.IGuiHandler
import de.thatsich.minecraft.common.module.Module


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class GuiRegistry
{
	def registerGuis(modules: Seq[Module]): IGuiHandler =
	{
		val table = new util.Hashtable[Int, BlockGuiHandler]()

		for (module <- modules)
		{
			module.foreach
			{
				case handler: BlockGuiHandler => table.put(handler.hashCode(), handler)
				case _                        =>
			}
		}

		new GuiBridge(table)
	}
}
