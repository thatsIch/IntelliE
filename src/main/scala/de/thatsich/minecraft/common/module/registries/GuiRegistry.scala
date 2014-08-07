package de.thatsich.minecraft.common.module.registries


import java.util

import cpw.mods.fml.common.network.IGuiHandler
import de.thatsich.minecraft.common.module.Module
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity


/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
class GuiRegistry
{
	private var id = 0
	private val table: util.Hashtable[Class[_ <: IGuiHandler], IGuiHandler] = new util.Hashtable[Class[_ <: IGuiHandler], IGuiHandler]()

	def registerGuis(modules: Seq[Module]): Unit =
	{
		for (module <- modules)
		{
			module.moduleParts.foreach
			{
				case handler: IGuiHandler => this.registerGui(handler)
				case _                    =>
			}
		}
	}

	private def registerGui(handler: IGuiHandler): Unit =
	{
		this.table.put(handler.getClass, handler)
	}

	def openGui(player: EntityPlayer, tile: TileEntity): Unit =
	{
		player.openGui()
	}
}
