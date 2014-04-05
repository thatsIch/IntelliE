package de.thatsich.intellie.applied.aerodynamics.common;

import de.thatsich.intellie.common.IInstantiate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @since 24.03.2014. */
@Singleton
public class AppliedAerodynamicsCreativeTab extends CreativeTabs implements IInstantiate
{
	@Inject
	public AppliedAerodynamicsCreativeTab()
	{
		super( "appliedAerodynamicsTab" );
	}

	@Override
	public Item getTabIconItem()
	{
		// TODO change to correct item or use ItemStack function
		return Items.spider_eye;
	}
}
