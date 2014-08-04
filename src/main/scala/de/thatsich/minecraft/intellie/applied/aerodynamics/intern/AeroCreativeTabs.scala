package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import de.thatsich.minecraft.api.mod.Modules
import de.thatsich.minecraft.api.mod.log.Log
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class AeroCreativeTabs( icon: Item, modules: Modules, log: Log ) extends CreativeTabs( "appaero" )
{
	for( module <- modules )
	{
		module.moduleParts.foreach
		{
			case item: Item => item.setCreativeTab( this )
			case block: Block => block.setCreativeTab( this )

			case _ =>
		}
	}

	override def getTabIconItem: Item =
	{
		this.icon
	}
}
