package de.thatsich.minecraft.intellie.applied.aerodynamics.functional.dissembler

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
class ItemDissembler extends Item
{
	this.setMaxStackSize(64)
	this.setCreativeTab(CreativeTabs.tabMisc)
	this.setUnlocalizedName("itemVajra")
}

object ItemDissembler extends ItemDissembler
