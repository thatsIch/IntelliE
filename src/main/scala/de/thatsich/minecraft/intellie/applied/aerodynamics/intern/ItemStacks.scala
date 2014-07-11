package de.thatsich.minecraft.intellie.applied.aerodynamics.intern

import de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler.ItemDissembler
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack

/**
 *
 *
 * @author thatsIch
 * @since 23.06.2014.
 */
object ItemStacks extends ItemStacks

class ItemStacks
{
	final val stoneStack      = new ItemStack( Blocks.stone )
	final val dissemblerStack = new ItemStack( ItemDissembler )
}
