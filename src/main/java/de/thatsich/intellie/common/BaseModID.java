package de.thatsich.intellie.common;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @since 02.04.2014. */
@Singleton
public class BaseModID
{
	private final String id;

	@Inject
	public BaseModID( final String id )
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return this.id;
	}
}
