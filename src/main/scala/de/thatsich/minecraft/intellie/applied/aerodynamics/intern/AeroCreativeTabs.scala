package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import cpw.mods.fml.common.registry.GameRegistry
import de.thatsich.minecraft.api.mod.Modules
import de.thatsich.minecraft.api.mod.log.Log
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntity

/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
private[ aerodynamics ] class AeroCreativeTabs( icon: Item, modules: Modules, log: Log ) extends CreativeTabs( "appliedAerodynamicsTab" )
{
	for( module <- modules )
	{
		(module.item, module.block, module.tileEntity, module.entity).productIterator.foreach
		{
			case Some( item: Item ) => item.setCreativeTab( this )
			case Some( block: Block ) => block.setCreativeTab( this )

			case None =>
			case any => log.severe( s"Unknown Module $module with $any" )
		}
	}

	override def getTabIconItem: Item =
	{
		this.icon
	}
}
