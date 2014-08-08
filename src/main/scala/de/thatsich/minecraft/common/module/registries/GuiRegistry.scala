package de.thatsich.minecraft.common.module.registries


import java.util

import cpw.mods.fml.common.network.IGuiHandler
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.Module


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class GuiRegistry(log: Log)
{
	def registerGuis(modules: Seq[Module]): IGuiHandler =
	{
		val table = new util.Hashtable[Int, BlockGuiHandler]()
		this.log.info("Processing " + modules.size + " elements")
		for (module <- modules)
		{
			module.foreach
			{
				case handler: BlockGuiHandler =>
					this.log.info(s"Adding handler $handler with hash " + handler.hashCode())
					table.put(handler.hashCode(), handler)
				case _                        =>
			}
		}

		new GuiBridge(table, this.log)
	}
}
