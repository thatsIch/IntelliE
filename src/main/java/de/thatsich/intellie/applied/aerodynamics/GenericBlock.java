package de.thatsich.intellie.applied.aerodynamics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 @author thatsIch
 @date 27.03.2014. */
public class GenericBlock extends Block
{
	protected GenericBlock ( final Material material )
	{
		super( material );
		this.setHardness( 0.5F );
		this.setStepSound( Block.soundTypeGravel );
		this.setBlockName( "genericBlock" );
		this.setCreativeTab( CreativeTabs.tabBlock );
	}

	@Override
	protected String getTextureName ()
	{
		return "appaero:genericBlock";
	}
}
