package de.thatsich.intellie.applied.aerodynamics.functionality.tool.vajra;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 @author thatsIch
 @since 27.03.2014. */
public class ItemVajra extends Item
{
	public ItemVajra()
	{
		super();
		this.setMaxStackSize( 64 );
		this.setCreativeTab( CreativeTabs.tabMisc );
		this.setUnlocalizedName( "itemVajra" );
	}
}
