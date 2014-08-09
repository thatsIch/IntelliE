package de.thatsich.minecraft.intellie.applied.aerodynamics.intern


import de.thatsich.minecraft.common.Modules
import de.thatsich.minecraft.common.log.Log
import de.thatsich.minecraft.common.string.ID
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item


/**
 *
 *
 * @author thatsIch
 * @since 05.04.2014.
 */
class AeroCreativeTabs(icon: Item, registrable: Modules, log: Log, modid: ID) extends CreativeTabs(modid)
{
	registrable.foreach
	{
		case item: Item   => item.setCreativeTab(this)
		case block: Block => block.setCreativeTab(this)

		case _ =>
	}

	override def getTabIconItem: Item =
	{
		this.icon
	}
}
