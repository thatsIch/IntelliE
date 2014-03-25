package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.intellie.common.module.item.IItem;
import de.thatsich.intellie.common.util.logging.ILog;
import net.minecraft.item.Item;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;

/**
 Handles registration of items

 @author thatsIch
 @date 25.02.14. */
@Singleton
public class ItemRegistry
{
	private final ILog log;
	private final Collection<IItem> items;

	/**
	 @param log Logger
	 */
	@Inject
	ItemRegistry ( final ILog log )
	{
		this.log = log;
		this.items = new LinkedList<IItem>();
	}

	public void addItem ( IItem item )
	{
		this.items.add( item );
		this.log.info( "Added Item %s.", item );
	}

	public void registerItems ()
	{
		this.log.info( "Registering all Items." );
		for ( final IItem item : this.items )
		{
			final String unlocalizedName = item.getUnlocalizedName();
			GameRegistry.registerItem( (Item) item, unlocalizedName );
		}
	}

}
