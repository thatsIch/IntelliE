package de.thatsich.intellie.applied.aerodynamics.decorative.generic.module;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @since 01.04.2014.
 */
@Singleton
public class GenericCreativeTabs extends CreativeTabs {

	@Inject
	public GenericCreativeTabs() {
		super("Generic");
	}

	@Override
	public Item getTabIconItem() {
		return null;
	}
}
