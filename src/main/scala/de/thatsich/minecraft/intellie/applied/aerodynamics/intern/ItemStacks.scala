package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler.DissemblerItem
import net.minecraft.init.Blocks
import net.minecraft.item.Item.ToolMaterial
import net.minecraft.item.ItemStack
import net.minecraftforge.common.util.EnumHelper

/**
 *
 *
 * @author thatsIch
 * @since 23.06.2014.
 */
private[ aerodynamics ] class ItemStacks
{
	final val mat: ToolMaterial = EnumHelper.addToolMaterial( "INSTANT", 3, 0, 5000, 1, 0 )

	final val dissembler = new DissemblerItem( )

	final val stoneStack      = new ItemStack( Blocks.stone )
	final val dissemblerStack = new ItemStack( dissembler )
}
