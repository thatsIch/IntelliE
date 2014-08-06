package de.thatsich.minecraft.common.module.registries

import cpw.mods.fml.common.network.IGuiHandler
import de.thatsich.minecraft.common.module.Module

/**
 *
 *
 * @author thatsIch
 * @since 06.08.2014.
 */
trait GuiRegistry
{
	def registerGuis( modules: Seq[ Module ] ): Unit =
	{
		for( module <- modules )
		{
			module.moduleParts.foreach
			{
				case handler: Class[ IGuiHandler ] => this.registerGui( handler )
				case _ =>
			}
		}
	}

	private def registerGui( handler: Class[ IGuiHandler ] ): Unit =
	{
		handler.newInstance
	}
}
