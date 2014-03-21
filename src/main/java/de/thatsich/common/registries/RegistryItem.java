package de.thatsich.common.registries;

import de.thatsich.common.module.item.IItem;
import de.thatsich.common.util.ILog;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 25.02.14.
 */
@Singleton
public class RegistryItem
{
	private final ILog log;

	@Inject
	RegistryItem ( ILog log )
	{
		this.log = log;
	}

	public void addItem ( IItem item )
	{

		this.log.info( "Added Item %s.", item );
	}

	public void registerItems ()
	{
		this.log.info( "Registering all Items." );
	}
}
