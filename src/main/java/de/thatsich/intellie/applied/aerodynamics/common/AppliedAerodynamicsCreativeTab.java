package de.thatsich.intellie.applied.aerodynamics.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.inject.Inject;

/**
 @author thatsIch
 @date 24.03.2014. */
public class AppliedAerodynamicsCreativeTab extends CreativeTabs
{
	@Inject
	public AppliedAerodynamicsCreativeTab ()
	{
		super( CreativeTabs.getNextID(), "appliedAerodynamicsTab" );
	}

	@Override
	public Item getTabIconItem ()
	{
		// TODO
		return null;
	}
}
