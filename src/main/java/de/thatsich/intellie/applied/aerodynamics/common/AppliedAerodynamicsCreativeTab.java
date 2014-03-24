package de.thatsich.intellie.applied.aerodynamics.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @date 24.03.2014. */
@Singleton
public class AppliedAerodynamicsCreativeTab extends CreativeTabs
{
	@Inject
	public AppliedAerodynamicsCreativeTab ()
	{
		super( "appliedAerodynamicsTab" );
	}

	@Override
	public Item getTabIconItem ()
	{
		// TODO change to correct item or use ItemStack function?
		return Items.spider_eye;
	}
}
