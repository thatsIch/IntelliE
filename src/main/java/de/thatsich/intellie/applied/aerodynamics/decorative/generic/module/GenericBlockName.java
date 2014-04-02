package de.thatsich.intellie.applied.aerodynamics.decorative.generic.module;

import de.thatsich.intellie.common.BaseModID;
import de.thatsich.intellie.common.module.block.info.ABlockName;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @since 01.04.2014. */
@Singleton
public class GenericBlockName extends ABlockName
{
	@Inject
	public GenericBlockName( final BaseModID id )
	{
		super( id );
	}
}
