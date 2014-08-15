package de.thatsich.minecraft
package common
package module
package registry


import java.util

import cpw.mods.fml.common.network.IGuiHandler
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.module.gui.{BlockGuiHandler, GuiBridge}


/**
 * Registers all block gui handlers to merge into a single IGuiHandler
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class GuiRegistry(registrable: Seq[Module], log: Log) extends BlockGuiHasher
{
	/**
	 * Registers all handlers and merge into a singe IGuiHandler
	 *
	 * @return merged gui handler
	 */
	def registerAll(): IGuiHandler =
	{
		val table = new util.Hashtable[Int, BlockGuiHandler]()
		var length = 0

		for (module: Module <- this.registrable; gui <- module.guis)
		{
			this.register(gui, table)
			length += 1
		}

		this.log.info(s"Finished loading $length gui handler(s).")

		new GuiBridge(table, this.log)
	}

	/**
	 * Stores the handler into a hashtable
	 *
	 * @param handler to be stored handler
	 * @param table in hashtable
	 */
	private def register(handler: BlockGuiHandler, table: util.Hashtable[Int, BlockGuiHandler]): Unit =
	{
		val name: String = handler.name
		val hash: Int = this.hash(name)

		this.log.debug(s"Adding handler ${handler.getClass.getSimpleName} with producing hash $hash")
		table.put(hash, handler)
	}
}
