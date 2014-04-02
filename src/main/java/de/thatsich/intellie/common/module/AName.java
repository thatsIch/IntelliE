package de.thatsich.intellie.common.module;

import de.thatsich.intellie.common.BaseModID;

import java.beans.Introspector;

/**
 @author thatsIch
 @since 02.04.2014. */
public abstract class AName implements IName
{
	private final String unlocalizedName;

	protected AName( BaseModID id )
	{
		final String name = this.getClass().getSimpleName().replaceFirst( "Name", "" );

		this.unlocalizedName = Introspector.decapitalize( name );
	}

	@Override
	public String getUnlocalizedName() { return this.unlocalizedName; }
}
