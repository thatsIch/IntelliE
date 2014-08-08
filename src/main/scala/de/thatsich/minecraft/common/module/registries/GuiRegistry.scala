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
					val name: String = handler.getClass.getSimpleName
					val hash: Int = this.getUniqueID(name)
					this.log.info(s"Adding handler $handler with hash $hash")
					table.put(hash, handler)
				case _                        =>
			}
		}

		new GuiBridge(table, this.log)
	}

	// TODO refactoring to commong
	private def getUniqueID(str: String): Int =
	{
		var h: Int = 0

		for (ch <- str)
		{
			h = 31 * h + ch
		}

		h
	}
}
