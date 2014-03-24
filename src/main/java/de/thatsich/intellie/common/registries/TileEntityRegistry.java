package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.intellie.common.module.tileentity.ITileEntity;
import de.thatsich.intellie.common.util.logging.ILog;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.config.Configuration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;

/**
 Registry for TileEntities
 */
@Singleton
public class TileEntityRegistry
{
	private final Collection<ITileEntity> tileEntities;
	private final ILog log;

	/**
	 @param log Injected Logger
	 */
	@Inject
	TileEntityRegistry ( ILog log )
	{
		this.tileEntities = new LinkedList<>();
		this.log = log;
	}

	/**
	 Adds a TileEntity

	 @param tileEntity added TileEntity
	 */
	public void addTileEntity ( ITileEntity tileEntity )
	{
		this.log.info( "Added Tile Entity: %s", tileEntity );
		this.tileEntities.add( tileEntity );
	}

	/**
	 Loads each config through their own responsibility

	 @param config Configuration
	 */
	public void loadConfig ( final Configuration config )
	{
		for ( ITileEntity tileEntity : this.tileEntities )
		{
			tileEntity.register( config );
		}
	}

	/**
	 Registers all added TileEntites through their clas and key
	 */
	public void registerTileEntities ()
	{
		for ( ITileEntity tileEntity : this.tileEntities )
		{
			final TileEntity te = (TileEntity) tileEntity;
			final Class<? extends TileEntity> tileEntityClass = te.getClass();
			final String tileEntityKey = tileEntity.getTileEntityID();

			GameRegistry.registerTileEntity( tileEntityClass, tileEntityKey );
		}
	}
}
